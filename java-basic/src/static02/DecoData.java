package static02;

public class DecoData {

    // 인스턴스 변수 //
    private int instanceValue;
    // 클래스 변수 (정적 변수) //
    private static int staticValue;

    // 인스턴스 메서드 //
    private void instanceMethod() {
        System.out.println("instanceValue = " + instanceValue);
    }

    // 클래스 메서드 //
    private static void staticMethod() {
        System.out.println("staticValue = " + staticValue);
    }

    // 클래스 메서드 (정적 메서드) //
    public static void staticCall() {

//        instanceValue++;   //인스턴스 변수 접근, 컴파일 에러
//        instanceMethod();  //인스턴스 메서드 접근, 컴파일 에러

        staticValue++;   //정적 변수 접근
        staticMethod();  //정적 메서드 접근
    }

    // 인스턴스 메서드 //
    public void instanceCall() {
        instanceValue++;
        instanceMethod();

        staticValue++;
        staticMethod();
    }

}
