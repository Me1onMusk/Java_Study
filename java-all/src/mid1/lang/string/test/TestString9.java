package mid1.lang.string.test;

/*
    <문제9>
        split() 를 사용해서 이메일의 ID 부분과 도메인 부분을 분리해라.
 */

public class TestString9 {
    public static void main(String[] args) {

        String email = "hello@example.com";

        //@를 기준으로 email의 아이디 부분과 도메인을 분리
        String[] parts = email.split("@");
        String idPart = parts[0];
        String domainPart = parts[1];

        System.out.println("ID: " + idPart);
        System.out.println("Domain: " + domainPart);

    }
}
