package adv3.functional;

import java.util.function.Function;

// 입력값이 동일하면 항상 동일한 결과를 반환한다 //
public class PureFunctionMain1 {
    public static void main(String[] args) {

        Function<Integer, Integer> func = x -> x * 2;

        System.out.println("result1 = " + func.apply(10));  // result1 = 20
        System.out.println("result2 = " + func.apply(10));  // result2 = 20

    }
}
