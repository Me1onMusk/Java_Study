package lang.string.test;

public class TestString11 {
    public static void main(String[] args) {

        String str = "Hello Java";

        StringBuilder reversed = new StringBuilder(str).reverse();
        System.out.println( reversed);

    }
}
