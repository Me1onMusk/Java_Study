package lang.string.test;

public class TestString02 {
    public static void main(String[] args) {

        String[] arr = { "hello", "java", "jvm", "spring", "jpa" };
        int sum = 0;

        for (String string : arr) {
            sum += string.length();
            System.out.println(string + ": " + string.length());
        }

        System.out.println( "sum = " + sum);
    }
}
