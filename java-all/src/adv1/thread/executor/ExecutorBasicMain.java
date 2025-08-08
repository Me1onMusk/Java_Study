package adv1.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static util.MyLogger.log;

public class ExecutorBasicMain {
    public static void main(String[] args) {

        // (기본 스레드 수, 최대 스레드 수, 생존할 수 있는 대기시간, 작업 대기 블로킹 큐)
        // 1. 기본 스레드 실행
        // 2. 모든 블로킹 큐가 찼는데 계속 들어오면 -> 최대 스레드 실행
        // 3. 초과 스레드는 생존 시간 후 소멸
        ExecutorService es = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());

        log("== 초기 상태 ==");
        es.execute(new RunnableTask("taskA"));
        es.execute(new RunnableTask("taskB"));
        es.execute(new RunnableTask("taskC"));
        es.execute(new RunnableTask("taskD"));

        log("== 작업 수행 중 ==");

        log("== 작업 수행 완료 ==");

        log("== shutdown 완료 ==");

    }
}
