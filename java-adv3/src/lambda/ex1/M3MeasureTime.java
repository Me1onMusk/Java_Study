package lambda.ex1;

import lambda.Procedure;

import java.util.Arrays;

public class M3MeasureTime {

    // 공통 : 실행 시간 측정 메서드
    public static void measureTime(Procedure procedure) {
        long startNs = System.nanoTime();  //시작 시간
        procedure.run();                    //바뀌는 로직 실행 (익명 클래스 or 람다로 전달)
        long endNs = System.nanoTime();    //종료 시간

        System.out.println("실행 시간: " + (endNs - startNs) + " ns");
    }

    public static void main(String[] args) {

        // 1.익명클래스로 for문
        measureTime(new Procedure() {
            @Override
            public void run() {
                int N = 100;
                int sum = 0;
                for(int i=0; i<N; i++) {
                    sum += i;
                }
                System.out.println("[1부터 " + N +"까지의 합] 결과: " + sum);
            }
        });

        // 2.익명클래스로 배열 정렬
        measureTime(new Procedure() {
            @Override
            public void run() {
                int[] arr = { 4, 3, 2, 1 };
                System.out.println("원본 배열: " + Arrays.toString(arr));
                Arrays.sort(arr);
                System.out.println("배열 정렬: " + Arrays.toString(arr));
            }
        });
    }
}
