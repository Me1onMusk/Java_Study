package lang.wrapper;

public class WrapperClassMain {
    public static void main(String[] args) {
        Integer newInteger = new Integer(10);   //Deprecated, 대신에 valueOf()를 사용 -> 박싱
        Integer integerObj = Integer.valueOf(10);  //-128 ~ 127 자주 사용하는 숫자 값 재사용, 불변 -> 박싱
        Long longObj = Long.valueOf(10L);
        Double doubleObj = Double.valueOf(10.0);
        
        System.out.println("newInteger = " + newInteger);
        System.out.println("integerObj = " + integerObj);
        System.out.println("longObj = " + longObj);
        System.out.println("doubleObj = " + doubleObj);

        System.out.println("내부 값 읽기");
        int intValue = integerObj.intValue();  // -> 언박싱
        System.out.println("intValue = " + intValue);

        long longValue = longObj.longValue();  // -> 언박싱
        System.out.println("longValue = " + longValue);

        System.out.println("비교");
        System.out.println("==: " + (newInteger == integerObj));
        System.out.println("equals: " + newInteger.equals(integerObj));
    }
}
