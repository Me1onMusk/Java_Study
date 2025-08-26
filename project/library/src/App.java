import domain.*;
import repository.BookRepository;
import repository.MemberRepository;
import repository.RentalRepository;
import repository.impl.InMemoryBookRepository;
import repository.impl.InMemoryMemberRepository;
import repository.impl.InMemoryRentalRepository;
import service.BookService;
import service.MemberService;
import service.RentalService;
import service.impl.BookServiceImpl;
import service.impl.MemberServiceImpl;
import service.impl.RentalServiceImpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// 메인 //
public class App {

    private static final Scanner sc = new Scanner(System.in);

    // Repository 생성
    private static final MemberRepository memberRepository = new InMemoryMemberRepository();
    private static final BookRepository bookRepository = new InMemoryBookRepository();
    private static final RentalRepository rentalRepository = new InMemoryRentalRepository();

    // Service 생성 (의존성 주입)
    private static final MemberService memberService = new MemberServiceImpl(memberRepository);
    private static final BookService bookService = new BookServiceImpl(bookRepository);
    private static final RentalService rentalService = new RentalServiceImpl(rentalRepository);

    public static void main(String[] args) {
        seed();
        while(true) {
            try {
                if(memberService.getCurrentUser() == null) {  //현재 사용자가 없으면
                    showWelcome();
                    int select = promptInt("선택");

                    switch (select) {
                        case 1 -> signUpFlow();
                        case 2 -> loginFlow();
                        case 3 -> {
                            System.out.println("이용해주셔서 감사합니다.");
                            return;
                        }
                        default -> System.out.println("[오류] 메뉴 번호를 다시 선택해주세요.");
                    }
                } else {  //현재 사용자가 있으면
                    showMainMenu();
                    int select = promptInt("선택");
                    if (memberService.getCurrentUser().getRole() == Role.ADMIN) { // 관리자 메뉴
                        switch (select) {
                            case 1 -> System.out.println("구현 필요"); // addBookFlow() ;
                            case 2 -> System.out.println("구현 필요"); // listBooksFlow();
                            case 3 -> System.out.println("구현 필요"); // searchFlow();
                            case 4 -> System.out.println("구현 필요"); // rentFlow();
                            case 5 -> System.out.println("구현 필요"); // returnFlow();
                            case 6 -> System.out.println("구현 필요"); // myRentalsFlow();
                            case 0 -> logout();
                            default -> System.out.println("[오류] 메뉴 번호를 다시 선택해주세요.");
                        }
                    } else { // 일반 사용자 메뉴
                        switch (select) {
                            case 1 -> System.out.println("구현 필요"); // listBooksFlow();
                            case 2 -> System.out.println("구현 필요"); // searchFlow();
                            case 3 -> System.out.println("구현 필요"); // rentFlow();
                            case 4 -> System.out.println("구현 필요"); // returnFlow();
                            case 5 -> System.out.println("구현 필요"); // myRentalsFlow();
                            case 0 -> logout();
                            default -> System.out.println("[오류] 메뉴 번호를 다시 선택해주세요.");
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("[오류] 숫자를 입력해주세요.");
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("[오류] " + e.getMessage());
                pause();
            } catch (Exception e) {
                System.out.println("[오류] 예상치 못한 오류: " + e.getMessage());
                pause();
            }
        }

    }

    // 초기 로그인 메뉴 //
    private static void showWelcome() {
        System.out.println("=== 도서 대여 시스템 ===");
        System.out.println("1) 회원가입   2) 로그인   3) 종료");
    }

    // 메인 메뉴 //
    private static void showMainMenu() {
        Member currentUser = memberService.getCurrentUser();

        System.out.printf("=== 메인 메뉴 (로그인: %s, 권한: %s) ===%n", currentUser.getName(), currentUser.getRole());

        if (currentUser.getRole() == Role.ADMIN)
            System.out.println("1) 도서 등록   2) 도서 목록   3) 도서 검색   4) 도서 대여   5) 도서반납   6) 내 대여목록   0) 로그아웃");
         else
            System.out.println("1) 도서 목록   2) 도서 검색   3) 도서 대여   4) 도서 반납   5) 내 도서 대여목록   0) 로그아웃");

    }

    // 회원 가입 //
    private static void signUpFlow() {
        System.out.println("[회원가입]");
        System.out.print("이름> ");
        String name = sc.nextLine().trim();
        System.out.print("이메일> ");
        String email = sc.nextLine().trim();
        System.out.print("비밀번호> ");
        String pw = sc.nextLine().trim();

        // 간단히 admin@admin.com 이면 ADMIN 권한
        Role role = email.equalsIgnoreCase("admin@admin.com") ? Role.ADMIN : Role.USER;

        try {
            Member m = memberService.signUp(name, email, pw, role);
            System.out.println("[성공] 회원가입 완료: " + m);
        } catch (Exception e) {
            System.out.println("[오류] " + e.getMessage());
        }
    }

    // 로그인 //
    private static void loginFlow() {
        System.out.println("[로그인]");
        System.out.print("이메일> ");
        String email = sc.nextLine().trim();
        System.out.print("비밀번호> ");
        String pw = sc.nextLine().trim();
        try {
            Member member = memberService.login(email, pw);
            System.out.println("[성공] 로그인: " + member.getName());
        } catch (Exception e) {
            System.out.println("[오류] " + e.getMessage());
        }
    }

    // 로그아웃 //
    private static void logout() {
        memberService.logout();
        System.out.println("[안내] 로그아웃 되었습니다.");
    }

    // 문자열 -> Int //
    private static int promptInt(String label) {
        System.out.print(label + "> ");
        String s = sc.nextLine().trim();
        return Integer.parseInt(s);
    }

    // 초기값 //
    private static void seed() {
        try {
            memberService.signUp("정원우", "wonwoo@test.com", "1234", Role.USER);
            memberService.signUp("김태영", "taeyoung@test.com", "1234", Role.USER);
            memberService.signUp("관리자", "admin@test.com", "1234", Role.ADMIN);
        } catch (Exception ignore) {}

//        service.addBook("978-89-7914-874-9", "자바의 정석", "남궁성", 5);
//        service.addBook("978-89-98142-35-3", "토비의 스프링 Vol.1", "이일민", 2);
//        service.addBook("978-89-98142-36-0", "토비의 스프링 Vol.2", "이일민", 2);

    }

    // ------------------ 수정필요 ------------------ //

    // ------------------ 회원 ------------------ //

    // 공백 제거 함수 //
    private static String promptNonEmpty(String label) {
        System.out.print(label + "> ");
        String s = sc.nextLine().trim();
        if (s.isEmpty())
            throw new IllegalArgumentException(label + "은(는) 필수입니다.");
        return s;
    }

//    // 로그인 확인 함수 //
//    private static void ensureLogin() {
//        if (currentUser == null)
//            throw new IllegalStateException("로그인 후 이용해주세요.");
//    }
//
//    // 문자열 -> Int //
////    private static int promptInt(String label) {
////        System.out.print(label + "> ");
////        String s = sc.nextLine().trim();
////        try {
////            return Integer.parseInt(s);
////        } catch (NumberFormatException e) {
////            throw new InputMismatchException();
////        }
////    }
//
//    // ------------------ 도서 ------------------ //
//    // 도서 추가 플로우 //
//    private static void addBookFlow() {
//        System.out.println("[도서 등록] (0 입력 시 취소)");
//
//        String isbn = promptNonEmpty("ISBN");
//        if (isbn.equals("0")) {
//            System.out.println("[안내] 도서 등록이 취소되었습니다.");
//            return;
//        }
//
//        String title = promptNonEmpty("제목");
//        if (title.equals("0")) {
//            System.out.println("[안내] 도서 등록이 취소되었습니다.");
//            return;
//        }
//
//        String author = promptNonEmpty("저자");
//        if (author.equals("0")) {
//            System.out.println("[안내] 도서 등록이 취소되었습니다.");
//            return;
//        }
//
//        int total = promptInt("총권수 (0 입력 시 취소)");
//        if (total == 0) {
//            System.out.println("[안내] 도서 등록이 취소되었습니다.");
//            return;
//        }
//
//        Book book = service.addBook(isbn, title, author, total);
//        System.out.printf("[성공] 등록 완료: bookId=%d, 재고=%d/%d%n", book.getId(), book.getAvailableCopies(), book.getTotalCopies());
//    }
//
//    // 도서 리스트 보기 플로우 //
//    private static void listBooksFlow() {
//        List<Book> list = service.listBooks();
//        System.out.println("[도서 목록] 총 " + list.size() + "권");
//        System.out.printf("%-4s %-20s %-20s %-16s %-8s%n", "ID", "ISBN", "제목", "저자", "재고/총");
//
//        for (Book book : list) {
//            System.out.printf("%-4d %-20s %-20s %-16s %d/%d%n",
//                    book.getId(),
//                    book.getIsbn(),
//                    truncate(book.getTitle(), 20),
//                    truncate(book.getAuthor(), 16),
//                    book.getAvailableCopies(),
//                    book.getTotalCopies());
//        }
//        pause();
//    }
//
//    // 문자열 자르기 //
//    private static String truncate(String s, int n) {
//        if (s == null)
//            return "";
//        return s.length() <= n ? s : s.substring(0, n - 1) + "…";
//    }
//
//    // 검색 플로우 //
//    private static void searchFlow() {
//        System.out.println("[도서 검색] (0 입력 시 취소)");
//        String keyword = promptNonEmpty("키워드(제목/저자/ISBN)");
//        if (keyword.equals("0")) {
//            System.out.println("[안내] 도서 검색이 취소되었습니다.");
//            return;
//        }
//
//        List<Book> list = service.searchBooks(keyword);
//
//        if (list.isEmpty()) {
//            System.out.println("검색 결과가 없습니다.");
//        } else {
//            System.out.println("검색 결과(" + list.size() + "건)");
//            System.out.printf("%-4s %-20s %-20s %-16s %-8s%n", "ID", "ISBN", "제목", "저자", "재고/총");
//            for (Book book : list) {
//                System.out.printf("%-4d %-20s %-20s %-16s %d/%d%n", book.getId(), book.getIsbn(), truncate(book.getTitle(), 20),
//                        truncate(book.getAuthor(), 16), book.getAvailableCopies(), book.getTotalCopies());
//            }
//        }
//        pause();
//    }
//
//    // 도서 대여 플로우 //
//    private static void rentFlow() {
//        ensureLogin();
//        System.out.println("[대여 가능한 도서 목록]");
//
//        List<Book> list = service.listBooks().stream().filter(b -> b.getAvailableCopies() > 0).toList();
//
//        if (list.isEmpty()) {
//            System.out.println("[안내] 현재 대여 가능한 도서가 없습니다.");
//            pause();
//            return;
//        }
//
//        System.out.printf("%-4s %-20s %-20s %-16s %-8s%n", "ID", "ISBN", "제목", "저자", "재고/총");
//        for (Book book : list) {
//            System.out.printf("%-4d %-20s %-20s %-16s %d/%d%n", book.getId(), book.getIsbn(), truncate(book.getTitle(), 20),
//                    truncate(book.getAuthor(), 16), book.getAvailableCopies(), book.getTotalCopies());
//        }
//
//        System.out.println("0 입력 시 취소 후 메뉴로 돌아갑니다.");
//        long bookId = promptInt("대여할 bookId 입력");
//        if (bookId == 0) {
//            System.out.println("[안내] 대여가 취소되었습니다.");
//            return;
//        }
//
//        Rental rental = service.rent(bookId, currentUser.getId());
//        Book after = service.getBook(bookId);
//
//        System.out.printf("[성공] 대여 완료: rentalId=%d, 반납예정일=%s, 재고=%d/%d%n",
//                rental.getId(),
//                rental.getDueAt(),
//                after.getAvailableCopies(),
//                after.getTotalCopies()
//        );
//        pause();
//    }
//
//    // 도서 반납 플로우 //
//    private static void returnFlow() {
//        ensureLogin();
//        System.out.println("[내가 반납할 수 있는 도서 목록]");
//
//        List<Rental> list = service.rentalsByMember(currentUser.getId()).stream().filter(r -> r.getStatus() == RentalStatus.RENTED).toList();
//
//        if (list.isEmpty()) {
//            System.out.println("[안내] 반납할 수 있는 도서가 없습니다.");
//            pause();
//            return;
//        }
//
//        System.out.printf("%-4s %-20s %-18s %-12s %-12s %-10s%n", "ID", "책제목", "ISBN", "대여일", "예정일", "상태");
//
//        for (Rental rental : list) {
//            Book book = service.getBook(rental.getBookId());
//            System.out.printf("%-4d %-20s %-18s %-12s %-12s %-10s%n", rental.getId(),
//                    book != null ? truncate(book.getTitle(), 20) : "(삭제됨)", book != null ? book.getIsbn() : "-", rental.getReturnedAt(), rental.getDueAt(),
//                    rental.getStatus());
//        }
//
//        System.out.println("0 입력 시 취소 후 메뉴로 돌아갑니다.");
//        long rentalId = promptInt("반납할 rentalId 입력");
//        if (rentalId == 0) {
//            System.out.println("[안내] 반납이 취소되었습니다.");
//            return;
//        }
//
//        Rental rental = service.returnBook(rentalId);
//        Book after = service.getBook(rental.getBookId());
//
//        System.out.printf("[성공] 반납 완료: status=%s, 재고=%d/%d%n",
//                rental.getStatus(),
//                after.getAvailableCopies(),
//                after.getTotalCopies()
//        );
//        pause();
//    }
//
//    // 내 대여목록 플로우 //
//    private static void myRentalsFlow() {
//        ensureLogin();
//        List<Rental> list = service.rentalsByMember(currentUser.getId());
//
//        if (list.isEmpty()) {
//            System.out.println("[안내] 현재/과거 대여 이력이 없습니다.");
//            pause();
//            return;
//        }
//
//        System.out.println("[나의 대여 목록]");
//        System.out.printf("%-4s %-20s %-18s %-12s %-12s %-10s%n", "ID", "책제목", "ISBN", "대여일", "예정일", "상태");
//
//        for (Rental rental : list) {
//            Book book = service.getBook(rental.getBookId());
//            String title = book != null ? truncate(book.getTitle(), 20) : "(삭제됨)";
//            String isbn = book != null ? truncate(book.getIsbn(), 18) : "-";
//
//            System.out.printf("%-4d %-20s %-18s %-12s %-12s %-10s%n",
//                    rental.getId(), title, isbn, rental.getRentedAt(), rental.getDueAt(), rental.getStatus());
//        }
//        pause();
//    }

    // 프로그램 중단 //

    private static void pause() {
        System.out.println("엔터를 누르면 메뉴로 돌아갑니다...");
        sc.nextLine();
    }

}
