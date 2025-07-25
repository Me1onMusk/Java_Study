package reflection;

import reflection.data.BasicData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodV2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // 정적 메서드 호출 - 일반적인 메서드 호출
        BasicData helloInstance = new BasicData();
        helloInstance.call();  //이 부분은 코드를 변경하지 않는 이상 정적이다. -> BasicData.call

        // 동적 메서드 호출 - 리플렉션 사용
        Class<? extends BasicData> helloClass = helloInstance.getClass();
        System.out.println("helloClass = " + helloClass);  //helloClass = class reflection.data.BasicData
        String methodName = "hello";

        // 메서드 이름을 변수로 변경할 수 있다.
        Method method1 = helloClass.getDeclaredMethod(methodName, String.class);
        System.out.println("method1 = " + method1);  // method1 = public java.lang.String reflection.data.BasicData.hello(java.lang.String)

        Object returnValue = method1.invoke(helloInstance, "hi");
        System.out.println("returnValue = " + returnValue);  //returnValue = hi hello

    }
}
