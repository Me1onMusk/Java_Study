package mid1.lang.string.method;

public class StringUtilsMain1 {
    public static void main(String[] args) {

        int num = 100;
        boolean bool = true;
        Object obj = new Object();
        String str = "Hello, Java!";

        // valueOf 메서드
        String numString = String.valueOf(num);
        System.out.println("숫자의 문자열 값: " + numString);     // 숫자의 문자열 값: 100
        String boolString = String.valueOf(bool);
        System.out.println("불리언의 문자열 값: " + boolString);  // 불리언의 문자열 값: true
        String objString = String.valueOf(obj);
        System.out.println("객체의 문자열 값: " + objString);     // 객체의 문자열 값: java.lang.Object@f6f4d33
        String numString2 = "" + num;                             // 문자열 + 숫자 -> 문자열
        System.out.println("빈문자열 + num:" + numString2);       // 빈문자열 + num:100

        // toCharArray 메서드
        char[] strCharArray = str.toCharArray();
        System.out.println("문자열을 문자 배열로 변환: " + strCharArray);  // 문자열을 문자 배열로 변환: [C@23fc625e
        for (char c : strCharArray) {
            System.out.print(c);  // Hello, Java!
        }
        System.out.println();

    }
}
