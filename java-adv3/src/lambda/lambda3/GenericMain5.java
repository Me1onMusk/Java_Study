package lambda.lambda3;

public class GenericMain5 {
    public static void main(String[] args) {

        GenericFunction<String, String> upperCase = s -> s.toUpperCase();
        System.out.println("result1 = " + upperCase.apply("hello"));

        GenericFunction<Integer, Integer> square = n -> n * n;
        System.out.println("result2 = " + square.apply(10));
    }

    @FunctionalInterface
    interface GenericFunction<T, R> {
        T apply(R o);
    }
}


