package mid2.generic.ex1;

public class BoxMain1 {
    public static void main(String[] args) {

        IntegerBox integerBox = new IntegerBox();
        integerBox.set(10);
        System.out.println("integer = " + integerBox.get());

        StringBox stringBox = new StringBox();
        stringBox.set("Hello");
        System.out.println("string = " + stringBox.get());

    }
}
