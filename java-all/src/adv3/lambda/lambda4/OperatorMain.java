package adv3.lambda.lambda4;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class OperatorMain {
    public static void main(String[] args) {

        // UnaryOperator
        Function<Integer, Integer> square1 = n -> n * n;
        UnaryOperator<Integer> square2 = n -> n * n;
        System.out.println("square1: " + square1.apply(5));
        System.out.println("square2: " + square2.apply(5));

        // BinaryOperator
        BiFunction<Integer, Integer, Integer> add1 = (n1, n2) -> n1 + n2;
        BinaryOperator<Integer> add2 = (n1, n2) -> n1 + n2;
        System.out.println("add1: " + add1.apply(5, 5));
        System.out.println("add2: " + add2.apply(5, 5));

    }
}
