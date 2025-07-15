package lambda.lambda4;


import java.util.function.Predicate;

// 입력 1개, 반환 Boolean
public class PredicateMain {
    public static void main(String[] args) {

        // 익명 클래스
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };
        System.out.println("predicate.test(10) = " + predicate.test(10));

        // 람다 함수
        Predicate<Integer> predicate2 = n -> n % 2 == 0;
        System.out.println("predicate2.test(10) = " + predicate2.test(10));

    }
}
