package thread.control;

import static util.MyLogger.log;

public class ThreadStateMain {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state1 = " + thread.getState());  //myThread.state1 = NEW (생성)

        log("myThread.start()");                        //myThread.start()
        thread.start();

        Thread.sleep(1000);                              //mainThread 1초 대기

        log("myThread.state3 = " + thread.getState());  //myThread.state3 = TIMED_WAITING
        Thread.sleep(4000);                              //mainThread 4초 대기
        log("myThread.state5 = " + thread.getState());  //myThread.state5 = TERMINATED

        log("end()");
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                log("start");

                log("myThread.state2 = " + Thread.currentThread().getState());  //myThread.state2 = RUNNABLE

                log("sleep() start");
                Thread.sleep(3000);
                log("sleep() end");

                log("myThread.state4 = " + Thread.currentThread().getState());  //myThread.state4 = RUNNABLE

                log("end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
