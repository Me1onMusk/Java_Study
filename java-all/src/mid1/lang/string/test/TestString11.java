package mid1.lang.string.test;

/*
    <문제11>
        str 문자열을 반대로 뒤집어라.
        StringBuilder 에 있는 reverse() 를 사용해라.
 */

public class TestString11 {
    public static void main(String[] args) {

        String str = "Hello Java";

//        StringBuilder sb = new StringBuilder();
//        for(Character c : str.toCharArray()) {
//            sb.append(c);
//        }
//        sb.reverse();
//        String result = sb.toString();
//        System.out.println(result);

        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println(reversed);

    }
}
