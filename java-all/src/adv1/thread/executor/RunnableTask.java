package adv1.thread.executor;

import static util.MyLogger.log;

public class RunnableTask implements Runnable{

    private final String name;
    private int sleepMs = 1000;

    public RunnableTask(String name) {
        this.name = name;
    }

    public RunnableTask(String name, int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }

    @Override
    public void run() {
        log("시작");
        
        log("완료");
    }
}
