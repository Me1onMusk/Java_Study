package mid1.lang.string;

public class StringEqualsMain1 {
    public static void main(String[] args) {

        // 문자열 객체 비교 //
        String str1 = new String("hello");  // 0x11
        String str2 = new String("hello");  // 0x12

        System.out.println(str1 == str2);  // false
        System.out.println(str1.equals(str2));  // true

        // 문자열 상수풀 //
        String str3 = "hello";
        String str4 = "hello";

        System.out.println("리터럴 == 비교 : " + (str3 == str4));  // 리터럴 == 비교 : true
        System.out.println("리터럴 equals 비교 : " + str3.equals(str4));  // 리터럴 equals 비교 : true

    }
}
