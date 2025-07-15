package lambda.lambda3;

public class GenericMain6 {
    public static void main(String[] args) {

        GenericFunction<String, String> upperCase = s -> s.toUpperCase();
        System.out.println("result1 = " + upperCase.apply("hello"));

        GenericFunction<String, Integer> stringLength = str -> str.length();
        System.out.println("result2 = " + stringLength.apply("hello"));

        GenericFunction<Integer, Boolean> isEven = n -> n % 2 == 0;
        System.out.println("result3 = " + isEven.apply(10));

        GenericFunction<Integer, Integer> square = n -> n * n;
        System.out.println("result4 = " + square.apply(10));
    }

    @FunctionalInterface
    interface GenericFunction<T, R> {
        R apply(T o);
    }
}


