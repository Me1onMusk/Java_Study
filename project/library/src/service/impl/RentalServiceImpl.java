package service.impl;

import domain.*;
import repository.BookRepository;
import repository.MemberRepository;
import repository.RentalRepository;
import service.BookService;
import service.RentalService;

import java.time.LocalDate;
import java.util.List;

public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final MemberRepository memberRepository;   // 회원 상태 변경을 위해 필요
    private final BookService bookService;       // 책 상태 확인을 위해 필요


    // 생성자 //
    public RentalServiceImpl(RentalRepository rentalRepository, MemberRepository memberRepository, BookService bookService) {
        this.rentalRepository = rentalRepository;
        this.memberRepository = memberRepository;
        this.bookService = bookService;
    }

    // 도서 대여 //
    @Override
    public Rental rentBook(long bookId, Member member) {

        // 1. 회원 상태 확인 (대여 정지 상태인지)
        // -> 대여중이라면 대여 종료일 출력
        if (member.isSuspended())
            throw new IllegalStateException("회원님이 대여 정지 상태입니다. 정지 종료일: " + member.getSuspendUtil());

        // 2. 연체 도서 여부 확인
        /*
            문제 없음 -> true
            연체 -> false
         */
        boolean hasOverdue = rentalRepository.findByMemberId(member.getId()).stream().anyMatch(Rental::isOverdue);
        if (hasOverdue)
            throw new IllegalStateException("연체된 도서가 있어 대여할 수 없습니다.");

        // 3. 일반 회원은 대여 권수 제한 (최대 7권)
        //     1) 회원인 경우 대여 도서가 있는지 조회
        if(member.getRole() == Role.USER) {
            long rentalCount = rentalRepository.findByMemberId(member.getId()).stream()
                    .filter(r -> r.getStatus() == RentalStatus.RENTED)
                    .count();
            if(rentalCount >= 7)
                throw new IllegalStateException("일반 회원은 최대 7권까지 대여할 수 있습니다.");
        }

        // 4. 도서 조회 및 재고 확인
        Book book = bookService.getBook(bookId);
        if (!book.isAvailableRent())
            throw new IllegalStateException("대여 가능한 재고가 없습니다.");

        // 5. 대여 정보 생성 (반납 예정일: 14일 뒤)
        Rental rental = new Rental(bookId, book.getTitle(), member.getId());

        // 5. 대여 정보 저장
        rentalRepository.save(rental);
        return rental;

    }

    // 책 반납 처리 //
    @Override
    public Rental returnBook(long rentalId) {

        // 1. 대여 정보 조회
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 대여 정보를 찾을 수 없습니다: " + rentalId));

        // 2. 반납 전에 연체 여부 확인 -> 연체 일수만큼 정지
        if(rental.isOverdue()) {
            rental.overdueDays();
        }

        // 3. 반납일 설정
        rental.markReturned(LocalDate.now());

        // 4. 책 상태를 '대여 가능'으로 변경 & 대여 가능 권수 늘리기
        Book book = bookService.getBook(rental.getBookId());
        book.returnBook();

        // 5. 변경된 대여 정보 저장
        rentalRepository.save(rental);
        return rental;
    }

    // 특정 회원의 모든 대여 기록 조회 //
    @Override
    public List<Rental> getRentalsByMember(Member member) {
        return rentalRepository.findByMemberId(member.getId());
    }

    // 회원의 연체 상태를 확인하고 정지 적용 //
    @Override
    public void checkOverdueAndApplySuspension(Member member) {

    }

}
