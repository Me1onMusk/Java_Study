package lang.object.tostring;

public class ToStringMain01 {
    public static void main(String[] args) {
        Object object = new Object();
        String string = object.toString();

        //getClass() 반환값 출력 -> class java.lang.Object
        System.out.println(object.getClass());

        //toString() 반환값 출력 -> java.lang.Object@f6f4d33
        System.out.println(string);

        //object 직접 출력 -> java.lang.Object@f6f4d33
        System.out.println(object);
    }
}
