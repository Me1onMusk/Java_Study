package mid2.generic.ex1;

// Raw type //
public class RawTypeMain {
    public static void main(String[] args) {

        GenericBox integerBox = new GenericBox();
        integerBox.set(10);
        System.out.println("integer = " + integerBox.get());

    }
}
