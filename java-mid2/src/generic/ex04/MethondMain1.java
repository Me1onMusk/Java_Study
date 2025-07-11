package generic.ex04;

public class MethondMain1 {
    public static void main(String[] args) {

        Integer i = 10;
        Object object = GenericMethod.objectMethod(i);
        Integer i1 = (Integer) object;  //다운 캐스팅

        // 타입 인자(Type Argument) 명시적 전달
        System.out.println("명지적 타입 인자 전달");
        Integer result = GenericMethod.<Integer>genericMethod(i);
        Integer integerValue = GenericMethod.<Integer>numberMethod(10);
        Double doubleValue = GenericMethod.<Double>numberMethod(10.0);

        System.out.println("타입 추론");
        Integer result1 = GenericMethod.genericMethod(i);
        Integer integerValue1 = GenericMethod.numberMethod(10);
        Double doubleValue1 = GenericMethod.numberMethod(10.0);

    }
}
