package lang.wrapper;

public class MyIntegerMethodMain02 {
    public static void main(String[] args) {
        MyInteger myInteger = new MyInteger(10);

        int i1 = myInteger.compareTo(5);
        System.out.println("i1 = " + i1);

        int i2 = myInteger.compareTo(10);
        System.out.println("i2 = " + i2);

        int i3 = myInteger.compareTo(20);
        System.out.println("i3 = " + i3);

    }
}
