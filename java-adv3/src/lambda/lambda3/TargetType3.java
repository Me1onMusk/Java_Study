package lambda.lambda3;

import java.util.function.Function;

// 자바가 기본으로 제공하는 Function 대입
public class TargetType3 {
    public static void main(String[] args) {

        // 람다 직업 대입: 문제 없음
        Function<Integer, String> funcA = i -> "Value = " + i;
        System.out.println(funcA.apply(10));

        Function<Integer, String> funcB = funcA;
        System.out.println(funcB.apply(20));

    }
}
