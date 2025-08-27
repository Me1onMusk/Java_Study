package service.impl;

import domain.Book;
import domain.Member;
import domain.Rental;
import repository.BookRepository;
import repository.MemberRepository;
import repository.RentalRepository;
import service.RentalService;

import java.time.LocalDate;
import java.util.List;

public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final BookRepository bookRepository;       // 책 상태 확인을 위해 필요
    private final MemberRepository memberRepository;   // 회원 상태 변경을 위해 필요

    // 생성자 //
    public RentalServiceImpl(RentalRepository rentalRepository, BookRepository bookRepository, MemberRepository memberRepository) {
        this.rentalRepository = rentalRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    // 도서 대여 //
    @Override
    public Rental rentBook(long bookId, Member member) {

        // 1. 회원 상태 확인 (대여 정지 상태인지)
        if (member.isSuspended() && member.getSuspensionEndDate().isAfter(LocalDate.now()))
            throw new IllegalStateException("회원님이 대여 정지 상태입니다. 정지 종료일: " + member.getSuspensionEndDate());

        // 2. 책 상태 확인 (대여 가능한지)
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 책을 찾을 수 없습니다: " + bookId));

        if (!book.isAvailable())
            throw new IllegalStateException("이미 대여 중인 책입니다.");

        // 3. 책 상태를 '대여 불가'로 변경
        book.setAvailable(false);
        bookRepository.save(book);

        // 4. 대여 정보 생성 (반납 예정일: 14일 뒤)
        Rental rental = new Rental(bookId, member.getId());

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

        // 2. 이미 반납되었는지 확인
        if (rental.getRentedAt() != null)
            throw new IllegalStateException("이미 반납 처리된 대여입니다.");

        // 3. 반납일 설정
        rental.markReturned(LocalDate.now());

        // 4. 책 상태를 '대여 가능'으로 변경
        Book book = bookRepository.findById(rental.getBookId())
                .orElseThrow(() -> new IllegalStateException("반납할 책을 찾을 수 없습니다."));
        book.setAvailable(true);
        bookRepository.save(book);

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
