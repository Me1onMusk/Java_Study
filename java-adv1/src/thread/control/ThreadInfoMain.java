package thread.control;

import thread.start.HelloRunnable;

import static util.MyLogger.log;

public class ThreadInfoMain {
    public static void main(String[] args) {
        // 메인 스레드 //
        Thread mainThread = Thread.currentThread();
        log("mainThread = " + mainThread);
        log("mainThread.threadId() = " + mainThread.getId());
        log("mainThread.threadName() = " + mainThread.getName());
        log("mainThread.getPriority() = " + mainThread.getPriority());  //기본은 5
        log("mainThread.ThreadGroup = " + mainThread.getThreadGroup()); //java.lang.ThreadGroup[name=main,maxpri=10]
        log("mainThread.getState() = " + mainThread.getState());        //RUNNABLE (실행될 준비가 된 상태)

        System.out.println();

        // MyThread 스레드 //
        Thread myThread = new Thread(new HelloRunnable(), "myThread");
        log("myThread = " + myThread);
        log("myThread.threadId() = " + myThread.getId());
        log("myThread.threadName() = " + myThread.getName());
        log("myThread.getPriority() = " + myThread.getPriority());  //기본은 5
        log("myThread.ThreadGroup = " + myThread.getThreadGroup()); //java.lang.ThreadGroup[name=main,maxpri=10]
        log("myThread.getState() = " + myThread.getState());        //NEW (스레드가 생성되고 시작되지 않은 상태)
    }
}
