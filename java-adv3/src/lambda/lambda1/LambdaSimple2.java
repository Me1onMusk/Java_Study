package lambda.lambda1;

import lambda.MyFunction;
import lambda.Procedure;

public class LambdaSimple2 {
    public static void main(String[] args) {

        // 기본
        Procedure procedure1 = () -> {
            System.out.println("Hello Lambda");
        };
        procedure1.run();

        // 단일 표현식은 중괄호 생략 가능
        Procedure procedure2 = () -> System.out.println("Hello Lambda");
        procedure2.run();
        
    }
}
