package adv3.lambda.lambda2;

import adv3.lambda.MyFunction;

public class LambdaPassMain2 {
    public static void main(String[] args) {

        MyFunction add = (a, b) -> a + b;  //람다 인스턴스 생성 (0x111)
        MyFunction sub = (a, b) -> a - b;  //람다 인스턴스 생성 (0x222)

        System.out.println("변수를 통해 전달");
        calculate(add);  // 참조값 대입
        calculate(sub);  // 참조값 대입

        System.out.println("람다를 직접 전달");
        calculate((a,b) -> a + b);
        calculate((a,b) -> a - b);

    }

    static void calculate(MyFunction function) {
        int a = 1;
        int b = 2;
        System.out.println("계산 시작");
        int result = function.apply(a, b);
        System.out.println("계산 결과: " + result);
    }
}
