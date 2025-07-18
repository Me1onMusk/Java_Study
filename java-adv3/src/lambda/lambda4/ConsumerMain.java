package lambda.lambda4;

import java.util.function.Consumer;

// 입려 1개, 출력 X
public class ConsumerMain {
    public static void main(String[] args) {

        //익명 클래스
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String string) {
                System.out.println(string);
            }
        };
        consumer1.accept("Hello");

        //람다 클래스
        Consumer<String> consumer2 = s -> System.out.println(s);
        consumer2.accept("World");

    }
}
