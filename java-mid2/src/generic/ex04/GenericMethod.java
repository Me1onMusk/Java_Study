package generic.ex04;

public class GenericMethod {

    public static Object objectMethod(Object obj) {
        System.out.println("Object print: " + obj);
        return obj;
    }

    // 제네릭 메서드 //
    public static <T> T genericMethod(T t) {
        System.out.println("generic print: " + t);
        return t;
    }

    // 제네릭 메서드 - 타입 제한 //
    public static <T extends Number> T numberMethod(T t) {
        System.out.println("bound print: " + t);
        return t;
    }

}
