package final01;

public class FinalLocalMain {
    public static void main(String[] args) {
        //final 지역변수1
        final int data1;  //변수 선언
        data1 = 10;       //변수 초기화
//        data1 = 20;     //컴파일 오류

        //final 지역변수2
        final int data2 = 20;

        method(10);
    }

    // final 매개변수 //
    static void method(final int parameter) {
//        parameter = 20;
        System.out.println(parameter);
    }
}
