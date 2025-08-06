package mid2.collection.deque;

import java.util.ArrayDeque;

public class DequeMain {
    public static void main(String[] args) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // 데이터 추가
        // First -> [2, 1]
        deque.offerFirst(1);
        System.out.println(deque);
        deque.offerFirst(2);
        System.out.println(deque);

        // [2, 1, 3, 4] <- Last
        deque.offerLast(3);
        System.out.println(deque);
        deque.offerLast(4);
        System.out.println(deque);


        // 다음 꺼낼 데이터 확인(꺼내지 않고 단순 조회만)
        System.out.println("deque.peekFirst() = " + deque.peekFirst());  // 2
        System.out.println("deque.peekLast() = " + deque.peekLast());    // 4

        // 데이터 꺼내기
        System.out.println("pollFirst = " + deque.pollFirst());
        System.out.println("pollFirst = " + deque.pollFirst());
        System.out.println("pollLast = " + deque.pollLast());
        System.out.println("pollLast = " + deque.pollLast());
        System.out.println(deque);

    }
}
