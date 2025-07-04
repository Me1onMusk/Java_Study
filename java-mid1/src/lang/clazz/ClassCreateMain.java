package lang.clazz;

// 리플렉션 //
// 클래스의 메타 정보를 기반으로 클래스를 조작
public class ClassCreateMain {
    public static void main(String[] args) throws Exception {
        Class helloClass = Hello.class;  //1. 클래스 조회
//        Class helloClass = Class.forName("lang.clazz.Hello");  //2. 문자열로 조회

        Hello hello = (Hello) helloClass.getDeclaredConstructor().newInstance();  //클래스로 인스턴스 생성
        String result = hello.hello();

        System.out.println("result = " + result);
    }
}
