package adv1.thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV2 {
    public static void main(String[] args) {

        log("main() start");

        // 익명 함수 //
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                log("run()");
//            }
//        };

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                log("run()");
//            }
//        });
//        thread.start();

        // 람다 함수 //
//        Runnable runnable = () -> log("run()");

        Thread thread = new Thread(() -> log("run()"));
        thread.start();

        log("main() end");

    }
}
