package adv3.lambda.lambda4;

public class RunnableMain {
    public static void main(String[] args) {

        /*
            Runnable
            @params: X
            @return: X
         */

        // 익명 클래스
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Runnable");
            }
        };
        runnable1.run();

        // 람다 클래스
        Runnable runnable2 = () -> System.out.println("Hello Runnable");
        runnable2.run();

    }
}
