package nested.local;

import java.lang.reflect.Field;

public class LocalOuterV4 {

    // 힙 영역 //
    private final int outInstanceVar = 3;

    // --- process() Frame --- //
    public Printer process(int paramVar) {
        int localVar = 1;  // 지역 변수 -> 스택 프레임이 종료되는 순간 함께 제거된다.

        // 지역 클래스
        class LocalPrinter implements Printer{

            final int value = 0;

            @Override
            public void print() {
                System.out.println("value = " + value);

                // 인스턴스는 지역 변수보다 더 오래 살아남는다.
                System.out.println("localVar = " + localVar);
                System.out.println("paramVar = " + paramVar);
                System.out.println("outInstanceVar = " + outInstanceVar);
            }
        }

        LocalPrinter printer = new LocalPrinter();
//        printer.print();

        // 만약 localVar의 값을 변경한다면?

        return printer;
    }

    // --- main() Frame --- //
    public static void main(String[] args) {
        LocalOuterV4 localOuter = new LocalOuterV4();
        // process() Frame -> 스택 프레임
        // private int outInstanceVar -> 힙 역역

        Printer printer = localOuter.process(2);
        printer.print();  //process()의 스택 프레임이 사라진 이후에 실행

        System.out.println("필드 확인");
        Field[] fields = printer.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }
    }
}
