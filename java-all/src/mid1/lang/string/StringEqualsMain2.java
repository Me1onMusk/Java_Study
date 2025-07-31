package mid1.lang.string;

public class StringEqualsMain2 {
    public static void main(String[] args) {

        // 문자열 객체 //
        String str1 = new String("hello");  // 0x11
        String str2 = new String("hello");  // 0x12

        System.out.println("메서드 호출 비교1 : " + isSame(str1, str2));  // 메서드 호출 비교1 : false

        // 문자열 상수풀 //
        String str3 = "hello";
        String str4 = "hello";

        System.out.println("메서드 호출 비교2 : " + isSame(str3, str4));  // 메서드 호출 비교2 : true
    }

    private static boolean isSame(String x, String y) {
        return x == y;
//        return x.equals(y);
    }
}
