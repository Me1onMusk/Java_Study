package adv3.lambda.lambda4;

public class TriMain {
    public static void main(String[] args) {

        TriFunction<Integer, Integer, Integer, Integer> add = (a, b, c) -> a + b + c;
        System.out.println(add.apply(1, 2, 3));

    }

    @FunctionalInterface
    interface TriFunction<A, B, C, R> {
        R apply(A a, B b, C c);
    }

}
