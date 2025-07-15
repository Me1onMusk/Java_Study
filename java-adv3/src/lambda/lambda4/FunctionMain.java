package lambda.lambda4;

import java.util.function.Function;

// 입력 1개, 출력 1개
public class FunctionMain {
    public static void main(String[] args) {

        // 익명 클래스
        Function<String, Integer> function1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String string) {
                return string.length();
            }
        };
        System.out.println("function1 = " + function1.apply("hello"));

        // 람다 클래스
        Function<String, String> function2 = s -> s.toUpperCase();
        System.out.println("function2 = " + function2.apply("world"));

    }
}
