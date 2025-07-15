package lambda.lambda4;

public class TriMain {
    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> triFunc = (s, i, d) -> s + i + d;
        System.out.println(triFunc.apply(1,2,3));
    }
}
