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
    private static final RentalService rentalService = new RentalServiceImpl(rentalRepository, bookRepository, memberRepository);

    public static void main(String[] args) {
        seed();
        while (true) {
            try {
                if (memberService.getCurrentUser() == null) {  //현재 사용자가 없으면
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
                            case 1 -> addBookFlow();
                            case 2 -> listBooksFlow();
                            case 3 -> searchFlow();
                            case 4 -> rentFlow();
                            case 5 -> returnFlow();
                            case 6 -> myRentalsFlow();
                            case 0 -> logout();
                            default -> System.out.println("[오류] 메뉴 번호를 다시 선택해주세요.");
                        }
                    } else { // 일반 사용자 메뉴
                        switch (select) {
                            case 1 -> listBooksFlow();
                            case 2 -> searchFlow();
                            case 3 -> rentFlow();
                            case 4 -> returnFlow();
                            case 5 -> myRentalsFlow();
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

    // 내 대여 목록 //
    private static void myRentalsFlow() {
        System.out.println("\n--- 나의 대여 기록 조회 ---");
        try {
            // 1. 현재 회원 
            Member member = memberService.getCurrentUser();

            // 3. 해당 회원의 모든 대여 기록을 가져옴
            List<Rental> rentals = rentalService.getRentalsByMember(member);

            // 4. 대여 기록 출력
            if (rentals.isEmpty())
                System.out.println("대여 기록이 없습니다.");

            rentals.forEach(rental -> {
                String status = (rental.getReturnedAt() == null) ? "대여 중" : "반납 완료";

                // 3. 포맷에 맞춰 출력
                System.out.printf("대여 ID: %-4d | 책 제목: %-20s | 상태: %-7s | 대여일: %s | 반납 예정일: %s\n",
                        rental.getId(),
                        rental.getBookId(),
                        status,
                        rental.getRentedAt(),
                        rental.getDueAt()
                );
            });
        } catch (NumberFormatException e) {
            System.out.println("❌ 오류: ID는 숫자로 입력해야 합니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ 오류: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ 알 수 없는 오류가 발생했습니다.");
        }
        System.out.println("--------------------");
    }

    // 도서 반납 //
    private static void returnFlow() {
        System.out.println("\n--- 책 반납 ---");
        try {
            // 1. 사용자로부터 반납할 대여 ID를 입력받음
            System.out.print("반납할 대여 ID를 입력하세요: ");
            long rentalId = Long.parseLong(App.sc.nextLine());

            // 2. RentalService의 returnBook 메서드 호출
            Rental returnedRental = rentalService.returnBook(rentalId);

            // 3. 반납된 책의 정보를 조회하여 성공 메시지 출력
            Book returnedBook = bookService.getBook(returnedRental.getBookId());

            System.out.println("✅ 반납이 완료되었습니다.");
            System.out.printf("반납된 책: %s\n", returnedBook.getTitle());
            System.out.printf("실제 반납일: %s\n", returnedRental.getReturnedAt());

        } catch (NumberFormatException e) {
            System.out.println("❌ 오류: ID는 숫자로 입력해야 합니다.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("❌ 오류: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ 알 수 없는 오류가 발생했습니다. 다시 시도해주세요.");
            e.printStackTrace();
        }
        System.out.println("--------------------");
    }

    // 도서 대출 //
    private static void rentFlow() {
        System.out.println("\n--- 책 대여 ---");
        try {
            // 1. 사용자로부터 책 ID를 입력받음
            System.out.print("대여할 책의 ID를 입력하세요: ");
            long bookId = Long.parseLong(App.sc.nextLine());

            // 2. 현재 회원 조회
            Member member = memberService.getCurrentUser();

            // 3. RentalService의 rentBook 메서드 호출
            Rental rental = rentalService.rentBook(bookId, member);

            // 4. 성공 메시지 출력
            System.out.println("✅ 대여가 완료되었습니다.");
            System.out.printf("대여 ID: %d\n", rental.getId());
            System.out.printf("반납 예정일: %s\n", rental.getDueAt());

        } catch (NumberFormatException e) {
            System.out.println("❌ 오류: ID는 숫자로 입력해야 합니다.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("❌ 오류: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ 알 수 없는 오류가 발생했습니다. 다시 시도해주세요.");
        }
        System.out.println("--------------------");
    }

    // 모든 도서 리스트 출력 //
    private static void listBooksFlow() {
        List<Book> books = bookService.listBooks();

        if (books.isEmpty())
            System.out.println("등록된 책이 없습니다.");
        else {
            for (Book book : books) {
                System.out.printf(
                        "ID: %d, 제목: %s, 저자: %s, 재고: %d\n",
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getTotalCopies()
                );
            }
        }
    }

    // 도서 추가 //
    private static void addBookFlow() {
        try {
            // 1.사용자 입력 받기
            System.out.print("ISBN: ");
            String isbn = App.sc.nextLine();
            System.out.print("제목: ");
            String title = App.sc.nextLine();
            System.out.print("저자: ");
            String author = App.sc.nextLine();
            System.out.print("보유 권수: ");
            int totalCopies = Integer.parseInt(App.sc.nextLine());

            // 2.사용자 입력 bookService로 넘겨주기
            Book book = bookService.registerBook(isbn, title, author, totalCopies);
            System.out.printf("등록 완료 (ID: %d, 제목: %s)\n", book.getId(), book.getTitle());

        } catch (NumberFormatException e) {
            System.out.println("오류: 보유 권수는 숫자로 입력해야 합니다.");
        } catch (IllegalStateException e) {
            System.out.println("오류: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("알 수 없는 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 도서 검색 //
    private static void searchFlow() {
        System.out.println("\n--- 책 검색 (제목, 저자 또는 ISBN) ---");
        System.out.print("검색어 입력: ");
        String keyword = App.sc.nextLine();

        if (keyword.trim().isEmpty()) {
            System.out.println("검색어를 입력해주세요.");
            System.out.println("--------------------");
            return;
        }

        List<Book> foundBooks = bookService.searchBooks(keyword);

        if (foundBooks.isEmpty()) {
            System.out.printf("'%s'에 대한 검색 결과가 없습니다.\n", keyword);
        } else {
            System.out.printf("'%s' 검색 결과 (%d건)\n", keyword, foundBooks.size());
            for (Book book : foundBooks) {
                System.out.printf("ID: %d, 제목: %s, 저자: %s, ISBN: %s\n",
                        book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn());
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
        } catch (Exception ignore) {
        }

        bookService.registerBook("978-89-7914-874-9", "자바의 정석", "남궁성", 5);
        bookService.registerBook("978-89-98142-35-3", "토비의 스프링 Vol.1", "이일민", 2);
        bookService.registerBook("978-89-98142-36-0", "토비의 스프링 Vol.2", "이일민", 2);

    }

    // 공백 제거 함수 //
    private static String promptNonEmpty(String label) {
        System.out.print(label + "> ");
        String s = sc.nextLine().trim();
        if (s.isEmpty())
            throw new IllegalArgumentException(label + "은(는) 필수입니다.");
        return s;
    }

    private static void pause() {
        System.out.println("엔터를 누르면 메뉴로 돌아갑니다...");
        sc.nextLine();
    }

}
