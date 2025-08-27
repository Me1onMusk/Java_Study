import domain.Book;
import domain.Member;
import domain.Rental;
import domain.Role;
import common.security.Passwords;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

// 비즈니스 로직 //
public class LibraryService {

    // 필드 //
    private final Map<Long, Member> members = new LinkedHashMap<>();
    private final Map<Long, Book> books = new LinkedHashMap<>();
    private final Map<Long, Rental> rentals = new LinkedHashMap<>();

    // ------------------ 멤버 ------------------ //
    // 회원 가입 //
    public Member signUp(String name, String email, String pw, Role role) {
        if (members.values().stream().anyMatch(m -> m.getEmail().equalsIgnoreCase(email)))  //일치하는 이메일이 존재하면~
            throw new IllegalStateException("이미 등록된 이메일입니다.");
        String hashed = Passwords.hash(pw);                     //비밀번호 해시처리
        Member member = new Member(name, email, hashed, role);  //새로운 멥버 객체 생성
        members.put(member.getId(), member);                    //멤버 리스트에 맴버 객체 넣기
        return member;                                          //맴버 반환
    }

    // 로그인 //
    public Member login (String email, String pw) {
        return members.values().stream()
                .filter(m -> m.getEmail().equalsIgnoreCase(email))
                .filter(m -> m.authenticate(pw))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다."));
    }

    // ------------------ 도서 ------------------ //
    // 도서 목록 //
    public List<Book> listBooks() {
        return new ArrayList<>(books.values());
    }

    // 도서 얻기 //
    // id 통해서 도서 얻기
    public Book getBook(long id) {
        return books.get(id);
    }

    // 도서 추가 //
    public Book addBook(String isbn, String title, String author, int total) {
        if (books.values().stream().anyMatch(b -> b.getIsbn().equalsIgnoreCase(isbn)))
            throw new IllegalStateException("이미 존재하는 ISBN입니다.");
        Book book = new Book(isbn, title, author, total);
        books.put(book.getId(), book);
        return book;
    }

    // 도서 검색 //
    public List<Book> searchBooks(String keyword) {
        String k = keyword.toLowerCase(Locale.ROOT);
        return books.values().stream()
                .filter(b ->
                        b.getTitle().toLowerCase(Locale.ROOT).contains(k) ||
                        b.getAuthor().toLowerCase(Locale.ROOT).contains(k) ||
                        b.getIsbn().toLowerCase(Locale.ROOT).contains(k)
                ).collect(Collectors.toList());
    }

    // 도서 대여 //
    public Rental rent(long bookId, long memberId) {
        // 연체 체크
        rentals.values().stream()
                .filter(r -> r.getMemberId() == memberId && r.isOverdue())
                .findAny()
                .ifPresent(r -> {
                    throw new IllegalStateException("연체 중이므로 대여 불가 (연체 일수: " + r.overdueDays() + "일)");
                });

        Book book = books.get(bookId);
        if (book == null) throw new IllegalArgumentException("도서를 찾을 수 없습니다.");
        if (book.getAvailableCopies() <= 0) throw new IllegalStateException("대여 가능 재고가 없습니다.");

        Book after = new Book(book.getId(), book.getIsbn(), book.getTitle(), book.getAuthor(), book.getTotalCopies(), book.getAvailableCopies() - 1);
        books.put(after.getId(), after);

        Rental rental = new Rental(bookId, memberId);
        rentals.put(rental.getId(), rental);
        return rental;
    }

    // 도서 반납 //
    public Rental returnBook(long rentalId) {
        Rental rental = rentals.get(rentalId);
        if (rental == null)
            throw new IllegalArgumentException("대여 건을 찾을 수 없습니다.");

        Rental returned = rental.markReturned(LocalDate.now());
        rentals.put(returned.getId(), returned);

        Book book = books.get(returned.getBookId());
        Book after = new Book(book.getId(), book.getIsbn(), book.getTitle(), book.getAuthor(), book.getTotalCopies(), book.getAvailableCopies() + 1);
        books.put(after.getId(), after);

        return returned;
    }

    // 멤버ID로 대여 조회 //
    public List<Rental> rentalsByMember(long memberId) {
        return rentals.values().stream()
                .filter(r -> r.getMemberId() == memberId)
                .sorted(Comparator.comparing(Rental::getRentedAt).reversed())
                .toList();
    }

}
