package memory;

public class JavaMemoryMain02 {
    // 메인 프레임 //
    public static void main(String[] args) {
        System.out.println("Main Start");
        method1();
        System.out.println("Main End");
    }

    // 메서드1 프레임 //
    static void method1() {
        System.out.println("method1 start");
        Data data1 = new Data(10);
        System.out.println("data.value: " + data1.getValue());
        method2(data1);
        System.out.println("data.value: " + data1.getValue());
        System.out.println("method1 end");
    }

    // 메서드2 프레임 //
    static void method2(Data data2) {
        System.out.println("method2 start");
        System.out.println("data.value: " + data2.getValue());
        data2.setValue(20);
        System.out.println("method2 end");
    }
}
