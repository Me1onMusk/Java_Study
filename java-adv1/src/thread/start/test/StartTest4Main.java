package thread.start.test;

import static java.lang.Thread.sleep;
import static util.MyLogger.*;

public class StartTest4Main {
    public static void main(String[] args) {
//        ThreadA threadA = new ThreadA();
//        threadA.start();

        Thread threadA = new Thread(new ThreadB("A", 1000), "Thread-A");
        Thread threadB = new Thread(new ThreadB("B", 500), "Thread-B");

        threadA.start();
        threadB.start();
    }

    static class ThreadA extends Thread {
        public ThreadA() {
            super("Thread-A");
        }
        @Override
        public void run() {
            while (true) {
                log("A");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class ThreadB implements Runnable {

        private final String content;
        private final int sleepTime;

        public ThreadB(String content, int sleepTime) {
            this.content = content;
            this.sleepTime = sleepTime;
        }

        @Override
        public void run() {
            while (true) {
                log(content);
                try {
                    sleep(sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
