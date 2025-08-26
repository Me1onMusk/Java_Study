import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

// 메인 //
public class App {

    private static final Scanner sc = new Scanner(System.in);
    private static final LibraryService service = new LibraryService();
    private static Member member = null;

    public static void main(String[] args) {

        seed();
        while(true) {
            try {

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

    // 메뉴 출력 //

    // ------------------ 회원 ------------------ //

    // 회원가입 플로우 //

    // 로그인 플로우 //

    // 로그아웃 플로우 //

    // ------------------ 도서 ------------------ //

    // 도서 추가 플로우 //

    // 도서 리스트 보기 플로우 //

    // 검색 플로우 //

    // 도서 대여 플로우 //

    // 도서 반납 플로우 //

    // 내 대여목록 플로우 //

    // 프로그램 중단 //
    private static void pause() {
        System.out.println("엔터를 누르면 메뉴로 돌아갑니다...");
        sc.nextLine();
    }

    // 초기값 //
    private static void seed() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// 이메일 정규식 //
class Patterns {
    private static final Pattern EMAIL = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    static boolean isEmail(String email) {
        return EMAIL.matcher(email).matches();
    }
}
