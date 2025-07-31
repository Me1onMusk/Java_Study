package mid2.collection.deque;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();

        //데이터 추가
        //  [1, 2, 3] <-
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue);  // [1, 2, 3]

        //다음 꺼낼 데이터 확인(꺼내지 않고 단순 조회만)
        System.out.println("queue.peek() = " + queue.peek());  // queue.peek() = 1

        //데이터 꺼내기
        // <- [1, 2, 3]
        System.out.println("poll = " + queue.poll());  // poll = 1
        System.out.println("poll = " + queue.poll());  // poll = 2
        System.out.println("poll = " + queue.poll());  // poll = 3

        System.out.println(queue); // []
    }
}
