package final01;

/*
    변수에 final 키워드가 붙으면 더는 값을 변경할 수 없다
 */

public class FinalLocalMain {
    public static void main(String[] args) {
        //final 지역변수1
        final int data1;
        data1 = 10;

        //final 지역변수2
        final int data2;
        data2 = 20;

//        method(10);
    }

    // final 매개변수 //
    static void method(final int parameter) {}
}
