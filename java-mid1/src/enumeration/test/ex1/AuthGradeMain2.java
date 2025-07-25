package enumeration.test.ex1;

import java.util.Scanner;

public class AuthGradeMain2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: ");
        String inputGrade = scanner.nextLine();

        AuthGrade authGrade = AuthGrade.valueOf(inputGrade.toUpperCase());
        System.out.printf("당신의 등급은 %s입니다. \n", authGrade.getLevel());
        System.out.println("==메뉴 목록==");
        
        if (authGrade.getLevel() > 0)
            System.out.println("- 메인 화면");
        if (authGrade.getLevel() > 1)
            System.out.println("- 이메일 관리 화면");
        if (authGrade.getLevel() > 2)
            System.out.println("- 관리자 화면");
        
    }
}
