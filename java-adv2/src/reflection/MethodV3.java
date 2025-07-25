package reflection;

import reflection.data.BasicData;
import reflection.data.Calculator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MethodV3 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Scanner sc = new Scanner(System.in);
        System.out.print("호출 메서드: ");
        String methodName = sc.nextLine();

        System.out.print("숫자1: ");
        int num1 = sc.nextInt();

        System.out.print("숫자2: ");
        int num2 = sc.nextInt();

        Calculator calculator = new Calculator();

        // 호출할 메서드를 변수 이름으로 동적으로 선택
        Class<? extends Calculator> aClass = Calculator.class;
        System.out.println("aClass: " + aClass);  //aClass: class reflection.data.Calculator

        Method method = aClass.getMethod(methodName, int.class, int.class);
        System.out.println("method: " + method);  //method: public int reflection.data.Calculator.add(int,int)

        Object returnValue = method.invoke(calculator, num1, num2);
        System.out.println("returnValue: " + returnValue);

    }
}
