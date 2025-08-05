package mid1.lang.clazz;

public class ClassCreateMain {
    public static void main(String[] args) throws Exception {

        Class helloClass = Class.forName("mid1.lang.clazz.Hello");
        Hello hello = (Hello) helloClass.getDeclaredConstructor().newInstance();

//        Hello hello = new Hello();

        String result = hello.hello();
        System.out.println("result = " + result);

    }
}
