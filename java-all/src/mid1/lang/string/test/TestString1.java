package mid1.lang.string.test;

/*
    <문제1>
        startsWith() 를 사용해서 url 이 https:// 로 시작하는지 확인해라
 */

public class TestString1 {
    public static void main(String[] args) {

        String url = "https://www.example.com";

        boolean result = url.startsWith("https://");
        System.out.println(result);

    }
}
