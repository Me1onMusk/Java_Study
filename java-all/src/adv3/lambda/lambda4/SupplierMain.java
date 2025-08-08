package adv3.lambda.lambda4;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierMain {
    public static void main(String[] args) {

        /*
            Supplier<T>
            @params: X
            @return: O
         */

        // 익명 클래스
        Supplier<Integer> supplier1 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);
            }
        };
        System.out.println("supplier1.get() = " + supplier1.get());

        // 람다 클래스
        Supplier<Integer> supplier2 = () -> new Random().nextInt(10);
        System.out.println("supplier2.get() = " + supplier2.get());

    }
}
