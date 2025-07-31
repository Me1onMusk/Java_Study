package adv1.thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV1 {
    public static void main(String[] args) {

        log("main() start");

        Runnable runnable = new myRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        log("main() end");

    }

    static class myRunnable implements Runnable{
        @Override
        public void run() {
            log("run()");
        }
    }
}
