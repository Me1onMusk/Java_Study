package mid2.generic.ex4;

public class MethodMain1 {
    public static void main(String[] args) {

        Integer i = 10;
        Object object = GenericMethod.objMethod(1);  // 입력 타입 Object

        System.out.println("명시적 타입 인자 전달");
        Integer result = GenericMethod.<Integer>genericMethod(i);

        // 반환 타입 Number타입 자식 T
        Integer integerValue = GenericMethod.<Integer>numberMethod(10);

        // 반환 타입 Number타입 자식 T
        Double doubleValue = GenericMethod.<Double>numberMethod(20.0);

    }
}
