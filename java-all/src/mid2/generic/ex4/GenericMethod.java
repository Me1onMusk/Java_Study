package mid2.generic.ex4;

public class GenericMethod {

    public static Object objMethod(Object obj) {
        System.out.println("object print: " + obj);
        return obj;
    }

    // 선언 <T>
    // @params: T
    // @return: T
    public static <T> T genericMethod(T obj) {
        System.out.println("T print: " + obj);
        return obj;
    }

    // @params: T extends Number
    // @return: T extends Number
    public static <T extends Number> T numberMethod(T obj) {
        System.out.println("bound print: " + obj);
        return obj;
    }

}
