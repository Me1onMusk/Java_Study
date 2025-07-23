package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ConstructV2 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Class<?> aClass = Class.forName("reflection.data.BasicData");
        Constructor<?> constructor = aClass.getDeclaredConstructor(String.class);  //String 인자가 필요한 생성자

        constructor.setAccessible(true);
        Object instance = constructor.newInstance("hello");  //생성자에 hello인자 주기
        System.out.println("instance = " + instance);  //instance = reflection.data.BasicData@3f99bd52

        Method method1 = aClass.getDeclaredMethod("call");
        method1.invoke(instance);  //메서드 호출

    }
}
