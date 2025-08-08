package adv2.reflection;

import adv2.reflection.data.BasicData;

import java.lang.reflect.Modifier;

public class BasicV2 {
    public static void main(String[] args) {

        Class<BasicData> basicData = BasicData.class;

        // 이름 //
        System.out.println("basicData.getName() = " + basicData.getName());
        // basicData.getName() = adv2.reflection.data.BasicData

        // 간단한 이름 //
        System.out.println("basicData.getSimpleName() = " + basicData.getSimpleName());
        // basicData.getSimpleName() = BasicData

        // 패키지명 //
        System.out.println("basicData.getPackage() = " + basicData.getPackage());
        // basicData.getPackage() = package adv2.reflection.data

        // 상위 클래스 //
        System.out.println("basicData.getSuperclass() = " + basicData.getSuperclass());
        // basicData.getSuperclass() = class java.lang.Object

        //
        System.out.println("basicData.getInterfaces() = " + basicData.getInterfaces());
        // basicData.getInterfaces() = [Ljava.lang.Class;@f6f4d33

        // 인터페이스 존재 여부 //
        System.out.println("basicData.getInterfaces() = " + basicData.isInterface());
        // basicData.getInterfaces() = false

        // Enum 존재 여부 //
        System.out.println("basicData.isEnum() = " + basicData.isEnum());
        // basicData.isEnum() = false

        // 애너테이션 존재 여부 //
        System.out.println("basicData.isAnnotation() = " + basicData.isAnnotation());
        // basicData.isAnnotation() = false

        // 접근 제어자 리플렉션 //
        int modifiers = basicData.getModifiers();
        System.out.println("basicData.getModifiers() = " + modifiers);
        // basicData.getModifiers() = 1

        System.out.println("isPublic = " + Modifier.isPublic(modifiers));
        // isPublic = true

        System.out.println("Modifier.toString() = " + Modifier.toString(modifiers));
        // Modifier.toString() = public

    }
}
