package lambda.lambda3;

public class GenericMain1 {
    public static void main(String[] args) {

        StringFunction upperCase = s -> s.toUpperCase();
        System.out.println("result1 = " + upperCase.apply("hello"));

        NumberFunction square = n -> n * n;
        System.out.println("result2 = " + square.apply(10));
    }

    @FunctionalInterface
    interface StringFunction {
        String apply(String s);
    }

    @FunctionalInterface
    interface NumberFunction {
        Integer apply(Integer n);
    }
}


