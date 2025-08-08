package adv3.lambda.lambda4;

import java.util.function.Consumer;

public class ConsumerMain {
    public static void main(String[] args) {

        /*
            Consumer<T>
            @params: T
            @return: X
         */

        // 익명 클래스
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("Hello");

        // 람다 클래스
        Consumer<String> consumer2 = (s) -> System.out.println(s);
        consumer2.accept("Hello");

        // 참조 클래스
        Consumer<String> consumer3 = System.out::println;
        consumer3.accept("Hello");

    }
}
