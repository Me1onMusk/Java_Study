package lambda.lambda3;

public class GenericMain3 {
    public static void main(String[] args) {

        ObjectFunction upperCase = new ObjectFunction() {
            @Override
            public Object apply(Object s) {
                return ((String) s).toUpperCase();
            }
        };
        System.out.println("result1 = " + upperCase.apply("hello"));

        ObjectFunction square = new ObjectFunction() {
            @Override
            public Object apply(Object n) {
                return (Integer) n * (Integer) n;
            }
        };
        System.out.println("result2 = " + square.apply(10));
    }

    @FunctionalInterface
    interface ObjectFunction {
        Object apply(Object o);
    }
}


