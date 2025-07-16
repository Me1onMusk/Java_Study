package annotation.mapping;

import java.lang.reflect.Method;

public class TestControllerMain {
    public static void main(String[] args) {

        TestController testController = new TestController();

        Class<? extends TestController> aClass = testController.getClass();
        for (Method method : aClass.getDeclaredMethods()) {
            SimpleMapping simpleMapping = method.getAnnotation(SimpleMapping.class);
            if(simpleMapping != null) {
                System.out.println("[" + simpleMapping.value() + "]" + " -> " + method);
            }
        }
    }
}

/*
    [/site1] -> public void annotation.mapping.TestController.page1()  : 리플렉션
    [/] -> public void annotation.mapping.TestController.home()        : 리플렉션
 */
