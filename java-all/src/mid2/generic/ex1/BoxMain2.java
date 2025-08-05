package mid2.generic.ex1;

public class BoxMain2 {
    public static void main(String[] args) {

        ObjectBox integerBox = new ObjectBox();
        integerBox.set(10);
        System.out.println("integer = " + integerBox.get());

        ObjectBox stringBox = new ObjectBox();
        stringBox.set("Hello");
        System.out.println("string = " + stringBox.get());

        integerBox.set("문자");  // java.lang.ClassCastException (타입 오류)
        Integer result = (Integer)integerBox.get();  //
        System.out.println("result = " + result);

    }
}
