package mid1.lang.string.method;

public class StringUtilsMain2 {
    public static void main(String[] args) {

        int num = 100;
        boolean bool = true;
        String str = "Hello, Java!";

        // format 메서드
        String format1 = String.format("num: %d, bool: %b, str: %s", num, bool, str);
        System.out.println(format1);  // num: 100, bool: true, str: Hello, Java!

        String format2 = String.format("숫자: %.2f", 10.1234);
        System.out.println(format2);  // 숫자: 10.12

        // printf
        System.out.printf("숫자: %.2f\n", 10.1234);  // 숫자: 10.12

        // matches 메서드
        String regex = "Hello, (Java!|World!)";
        System.out.println("'str'이 패턴과 일치하는가? " + str.matches(regex));  // 'str'이 패턴과 일치하는가? true

    }
}
