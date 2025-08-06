package adv1.thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class LockSupportMainV1 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new ParkTask(), "Thread-1");
        thread1.start();

        // 잠시 대기하여 Thread-1이 park 상태에 빠질 시간을 준다.
        sleep(100);  // 0.1초 대기
        log("Thread-1 state: " + thread1.getState());
        LockSupport.unpark(thread1);
        log("main -> unpark(Thread-1)");

    }

    static class ParkTask implements Runnable{
        @Override
        public void run() {
            log("park 시작");
            LockSupport.park();  // waiting으로 변경
            log("park 종료, state: " + Thread.currentThread().getState());
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        }
    }

}
