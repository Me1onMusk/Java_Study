package lambda.lambda4;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiMain {
    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        System.out.println("add = " + add.apply(10, 20));

        BiConsumer<String, Integer> repeat = (s, n) -> {
            for (int i = 0; i < n; i++) {
                System.out.print(s);
            }
            System.out.println();
        };
        repeat.accept("*", 5);

        BiPredicate<Integer, Integer> isGreater = (x, y) -> x > y;
        System.out.println("isGreater = " + isGreater.test(10, 20));

    }
}
