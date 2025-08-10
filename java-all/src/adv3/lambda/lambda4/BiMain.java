package adv3.lambda.lambda4;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiMain {
    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> add = (n1, n2) -> n1 + n2;
        System.out.println("add: " + add.apply(5, 5));

        BiConsumer<String, Integer> repeat = (c, n) -> {
            for (int i = 0; i < n; i++) {
                System.out.print(c);
            }
            System.out.println();
        };
        repeat.accept("a", 5);

        BiPredicate<Integer, Integer> isGreater = (a,b) -> a > b;
        System.out.println("isGreater: " + isGreater.test(5, 10));

    }
}
