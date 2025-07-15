package lambda.lambda3;

public class TargetType1 {
    public static void main(String[] args) {

        // 람다 직접 대입: 문제 없음
        FuncA funcA = i -> "value = " + i;
        FuncB funcB = i -> "value = " + i;
        System.out.println("funcA = " + funcA.apply(10));

        // 이미 만들어진 funcA 인스턴스를 FuncB에 대입: 불가능
//        FuncB funcB = funcA;

    }

    @FunctionalInterface
    interface FuncA {
        String apply(Integer i);
    }

    @FunctionalInterface
    interface FuncB {
        String apply(Integer i);
    }
}
