package adv3.functional;

import java.util.function.Function;

// 부수효과(Side Effect) - 외부상태 변화 //
public class SideEffectMain1 {

    public static int count = 0;

    public static void main(String[] args) {

        System.out.println("before count = " + count);  // before count = 0

        Function<Integer, Integer> func = x -> {
            count++;
            return x * 2;
        };
        func.apply(10);

        System.out.println("after count = " + count);  // after count = 1

    }
}
