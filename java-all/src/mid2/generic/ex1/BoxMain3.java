package mid2.generic.ex1;

public class BoxMain3 {
    public static void main(String[] args) {

        GenericBox<Integer> integerBox = new GenericBox<>();
        integerBox.set(10);
        System.out.println("integer = " + integerBox.get());

        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.set("Hello");
        System.out.println("string = " + stringBox.get());

//        integerBox.set("문자");  // 컴파일 오류 발생 -> 제네릭
//        System.out.println("integer = " + integerBox.get());

    }
}
