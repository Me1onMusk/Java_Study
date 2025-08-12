package adv3.functional;

import java.util.function.Function;

// 콘솔에 출력을 하는 동작이 부수효과 //
public class SideEffectMain2 {
    public static void main(String[] args) {

        Function<Integer, Integer> func = x -> {
            int result = x * 2;
            // 부수 효과(Side Effect)
            System.out.println("x = " + x + ", result = " + (x * 2));  // x = 10, result = 20
            return result;
        };
        func.apply(10);

    }
}
