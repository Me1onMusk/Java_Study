package lambda.lambda4;

import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntFunction;

public class PrimitiveFunction {
    public static void main(String[] args) {

        // 기본형 매개변수: IntFunction, LongFunction, DoubleFunction
        IntFunction<String> func = x -> "숫자: " + x;
        System.out.println(func.apply(10));

        // 기본형 반환: ToIntFunction, ToLongFunction, ToDoubleFunction
        ToIntFunction<String> toIntFunction = s -> s.length();
        toIntFunction.applyAsInt("Hello");

        // 기본형 매개변수, 기본형 반환: int -> long
        IntToLongFunction intToLongFunction = x -> x * 10L;
        System.out.println(intToLongFunction.applyAsLong(10));

        // IntUnaryOperator: int -> int
        IntUnaryOperator intUnaryOperator = x -> x * 10;
        System.out.println(intUnaryOperator.applyAsInt(10));

        // 기타, IntConsumer, IntSupplier, IntPredicate

    }
}
