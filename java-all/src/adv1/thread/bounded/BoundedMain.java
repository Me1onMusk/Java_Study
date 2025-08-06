package adv1.thread.bounded;

import java.util.ArrayList;
import java.util.List;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BoundedMain {
    public static void main(String[] args) {

        // 1. BoundedQueue 선택
        // 사이즈가 2인 창고
//        BoundedQueue queue = new BoundedQueueV1(2);
//        BoundedQueue queue = new BoundedQueueV2(2);
        BoundedQueue queue = new BoundedQueueV3(2);

        // 2. 생산자, 소비자 실행 순서 선택, 반드시 하나만 선택!
        producerFirst(queue);  // 생산자 먼저 실행
//        consumerFirst(queue);  // 소비자 먼저 실행

    }

    // 생산자 먼저 생산 //
    private static void producerFirst(BoundedQueue queue) {
        log("== [생산자 먼저 실행] 시작, " + queue.getClass().getSimpleName() + " ==");

        List<Thread> threads = new ArrayList<>();
        startProducer(queue, threads);  // 생산 시작
        printAllState(queue, threads);
        startConsumer(queue, threads);  // 소비 시작
        printAllState(queue, threads);

        log("== [생산자 먼저 실행] 종료, " + queue.getClass().getSimpleName() + " ==");
    }

    // 소비자 먼저 소비 //
    private static void consumerFirst(BoundedQueue queue) {
        log("== [소비자 먼저 실행] 시작, " + queue.getClass().getSimpleName() + " ==");

        List<Thread> threads = new ArrayList<>();
        startConsumer(queue, threads);  // 소비 시작
        printAllState(queue, threads);
        startProducer(queue, threads);  // 생산 시작
        printAllState(queue, threads);

        log("== [소비자 먼저 실행] 종료, " + queue.getClass().getSimpleName() + " ==");
    }

    // 생산 시작 //
    private static void startProducer(BoundedQueue queue, List<Thread> threads) {
        System.out.println();
        log("생산자 시작");
        for(int i=1; i<=3; i++) {
            Thread producer = new Thread(new ProducerTask(queue, "data" + i), "producer" + i);

            threads.add(producer);
            producer.start();
            sleep(100);
        }
    }

    // 소비 시작 //
    private static void startConsumer(BoundedQueue queue, List<Thread> threads) {
        System.out.println();
        log("소비자 시작");
        for(int i=1; i<=3; i++) {
            Thread consumer = new Thread(new ConsumerTask(queue), "consumer" + i);

            threads.add(consumer);
            consumer.start();
            sleep(100);
        }
    }

    // 모든 상태 출력 //
    private static void printAllState(BoundedQueue queue, List<Thread> threads) {
        System.out.println();
        log("현재 상태 출력, 큐 데이터: " + queue);
        for (Thread thread : threads) {
            log(thread.getName() + ": " + thread.getState());
        }
    }
}
