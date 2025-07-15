package lambda.ex2;

// 함수 반환 //
public class BuilderGreeterExample {

    // 고차함수, greeting 문자열을 받아, "새로운 함수를" 반환
    public static StringFunction builderGreeting(String greeting) {
        return s -> greeting + ", " + s;
    }

    public static void main(String[] args) {
        StringFunction helloGreeter = builderGreeting("Hello");
        StringFunction hiGreeter = builderGreeting("Hi");

        System.out.println(helloGreeter.apply("Java"));  //Hello, Java
        System.out.println(hiGreeter.apply("Lambda"));   //Hi, Lambda
    }
}
