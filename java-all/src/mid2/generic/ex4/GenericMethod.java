package mid2.generic.ex4;

public class GenericMethod {

    public static Object objMethod(Object obj) {
        System.out.println("object print: " + obj);
        return obj;
    }

    // 입력 타입 T
    // 반환 타입 T
    public static <T> T genericMethod(T obj) {
        System.out.println("T print: " + obj);
        return obj;
    }

    // 입력 타입 T
    // 반환 타입 Number 자식 T
    public static <T extends Number> T numberMethod(T obj) {
        System.out.println("bound print: " + obj);
        return obj;
    }

}
