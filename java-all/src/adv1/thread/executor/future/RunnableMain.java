package adv1.thread.executor.future;

import java.util.Random;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class RunnableMain {
    public static void main(String[] args) throws InterruptedException {

        MyRunnable task = new MyRunnable();
        Thread thread = new Thread(task, "Thread-1");

        thread.start();
        thread.join();  // Thread-1이 종료될때까지 main 스레드 대기

        int value = task.value;
        log("result value = " + value);

    }

    static class MyRunnable implements Runnable{
        int value;
        @Override
        public void run() {
            log("Runnable 시작");
            sleep(2000);  // 2초 대기
            value = new Random().nextInt(10);
            log("create value = " + value);
            log("Runnable 종료");
        }
    }
}
