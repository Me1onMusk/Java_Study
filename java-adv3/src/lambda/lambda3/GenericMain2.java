package lambda.lambda3;

public class GenericMain2 {
    public static void main(String[] args) {

        ObjectFunction upperCase = s -> ((String) s).toUpperCase();
        System.out.println("result1 = " + upperCase.apply("hello"));

        ObjectFunction square = n -> (Integer) n * (Integer) n;
        System.out.println("result2 = " + square.apply(10));
    }

    @FunctionalInterface
    interface ObjectFunction {
        Object apply(Object o);
    }
}


