package mid1.lang.string;

public class StringInfoMain {
    public static void main(String[] args) {

        String str = "Hello, Java!";

        System.out.println("문자열 길이 : " + str.length());  // 문자열 길이 : 12
        System.out.println("문자열이 비어 있는지 : " + str.isEmpty());  // 문자열이 비어 있는지 : false
        System.out.println("문자열이 비어 있거나 공백인지1 : " + str.isBlank());  // 문자열이 비어 있거나 공백인지1 : false

        System.out.println("문자열이 비어 있거나 공백인지2 : ".isBlank());  // false

        char c = str.charAt(7);
        System.out.println("7번 인덱스의 문자 : " + c);  // 7번 인덱스의 문자 : J
    }
}
