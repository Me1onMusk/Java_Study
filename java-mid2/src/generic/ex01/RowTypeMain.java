package generic.ex01;

public class RowTypeMain {
    public static void main(String[] args) {
        GenericBox integerBox = new GenericBox();
//        GenericBox<Object> integerBox = new GenericBox<>();

        integerBox.set(10);
        Integer result = (Integer) integerBox.get();
//        String result = (String) integerBox.get();

        System.out.println("result = " + result);
    }
}
