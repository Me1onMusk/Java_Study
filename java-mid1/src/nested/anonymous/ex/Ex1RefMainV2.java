package nested.anonymous.ex;

import java.util.Random;

public class Ex1RefMainV2 {

    public static void hello(Process process) {
        System.out.println("프로그램 시작");
        process.run();
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {

        // 지역 클래스 //
        class Dice implements Process {
            @Override
            public void run() {
                // 코드 조각 시작
                int randomValue = new Random().nextInt(6) + 1;
                System.out.println("주사위 = " + randomValue);
                // 코드 조각 종료
            }
        }

        // 지역 클래스 //
        class Sum implements Process {
            @Override
            public void run() {
                // 코드 조각 시작
                for (int i = 1; i <= 3; i++) { System.out.println("i = " + i); }
                // 코드 조각 종료
            }
        }

        hello(new Dice());
        hello(new Sum());
    }
}
