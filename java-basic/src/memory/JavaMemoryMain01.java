package memory;

public class JavaMemoryMain01 {
    // 메인 프레임//
    public static void main(String[] args) {
        System.out.println( "Main Start");
        method1(10);
        System.out.println( "Main End");
    }

    // 메서드1 프레임 //
    static void method1(int value) {
        System.out.println("method1 start");
        int cal = value * 2;
        method2(cal);
        System.out.println("method1 end");
    }

    // 메서드2 프레임 //
    static void method2(int value) {
        System.out.println("method2 start");
        int cal = value * 3;
        System.out.println("method2 end");
    }
}
