package mid1.lang.string.test;

/*
    <문제7>
        문자의 양쪽 공백을 제거해라. 예) " Hello Java " "Hello Java"
 */

public class TestString7 {
    public static void main(String[] args) {

        String original = " Hello Java ";

        String trimmed = original.trim();
        System.out.println(trimmed);

        String stripped = original.strip();
        System.out.println(stripped);

    }
}
