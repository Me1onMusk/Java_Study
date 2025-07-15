package lambda.lambda3;

public class GenericMain4 {
    public static void main(String[] args) {

        GenericFunction<String, String> upperCase = new GenericFunction<>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };
        System.out.println("result1 = " + upperCase.apply("hello"));

        GenericFunction<Integer, Integer> square = new GenericFunction<>() {
            @Override
            public Integer apply(Integer n) {
                return n * n;
            }
        };
        System.out.println("result2 = " + square.apply(10));
    }

    @FunctionalInterface
    interface GenericFunction<T, R> {
        R apply(T o);
    }
}


