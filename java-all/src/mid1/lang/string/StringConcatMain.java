package mid1.lang.string;

public class StringConcatMain {
    public static void main(String[] args) {

        String a = "hello";
        String b = "java";

        String result1 = a.concat(b);
        String result2 = a + b;

        System.out.println("result1 = " + result1);  // result1 = hellojava
        System.out.println("result2 = " + result2);  // result2 = hellojava

    }
}
