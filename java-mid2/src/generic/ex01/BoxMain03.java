package generic.ex01;

public class BoxMain03 {
    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<Integer>();  //생성 시점에 T의 타입 결정
        integerBox.set(10);
        Integer integer = integerBox.get();  //Integer 타입 반환(캐스팅 X)
        System.out.println("integer = " + integer);

        GenericBox<String> stringBox = new GenericBox<String>();
        stringBox.set("hello");
        String string = stringBox.get();
        System.out.println("string = " + string);

        GenericBox<Double> doubleBox = new GenericBox<Double>();
        doubleBox.set(10.0);
        Double doubleValue = doubleBox.get();
        System.out.println("double = " + doubleValue);

        //타입 추론 : 생성하는 제네릭 타입 생략 가능
        GenericBox<Integer> integerBox2 = new GenericBox<>();
        integerBox2.set(10);
        Integer integer2 = integerBox2.get();
        System.out.println("integer2 = " + integer2);
    }
}
