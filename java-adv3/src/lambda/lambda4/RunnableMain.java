package lambda.lambda4;

// 입력 X, 출력 X
public class RunnableMain {
    public static void main(String[] args) {

        // 익명 클래스
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Runnable");
            }
        };
        runnable1.run();

        // 람다 클래스
        Runnable runnable2 = () -> System.out.println("Hello Lambda");
        runnable2.run();

    }
}
