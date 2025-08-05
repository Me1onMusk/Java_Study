package mid1.lang.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassMetaMain {
    public static void main(String[] args) {

        // Class 조회
        Class clazz = String.class;

        // 모든 필드 출력
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            System.out.println("Field: " + field.getType() + " " + field.getName());
        }

        System.out.println();

        // 모든 메서드 출력
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods) {
            System.out.println("Method: " + method.getReturnType() + " " + method.getName());
        }

        System.out.println();

        // 상위 클래스 정보 출력
        System.out.println("Superclass: " + clazz.getSuperclass());  // Superclass: class java.lang.Object

        System.out.println();

        // 인터페이스 정보 출력
        Class[] interfaces = clazz.getInterfaces();
        for(Class i : interfaces) {
            System.out.println("Interface: " + i.getName());
        }
    }
}
