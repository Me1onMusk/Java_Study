package mid1.lang.string.method;

public class StringChangeMain2 {
    public static void main(String[] args) {

        String strWithSpaces = " Java Programming ";

        System.out.println("소문자로 변환: " + strWithSpaces.toLowerCase());  // 소문자로 변환:  java programming
        System.out.println("대문자로 변환: " + strWithSpaces.toUpperCase());  // 대문자로 변환:  JAVA PROGRAMMING

        System.out.println("공백 제거(trim): '" + strWithSpaces.trim() + "'");    // 공백 제거(trim): 'Java Programming'
        System.out.println("공백 제거(strip): '" + strWithSpaces.strip() + "'");  // 공백 제거(strip): 'Java Programming'

        System.out.println("앞 공백 제거(strip): '" + strWithSpaces.stripLeading() + "'");   // 앞 공백 제거(strip): 'Java Programming '
        System.out.println("뒤 공백 제거(strip): '" + strWithSpaces.stripTrailing() + "'");  // 뒤 공백 제거(strip): ' Java Programming'

    }
}
