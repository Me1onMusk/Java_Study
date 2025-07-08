package lang.wrapper.test;

public class WrapperTest2 {
    public static void main(String[] args) {

        String[] array = { "1.5", "2.5", "3.0" };
        double sum = 0;
        for(String str : array) {
            double d = Double.parseDouble(str);
            sum += d;
        }
        System.out.println("sum = " + sum);

    }
}
