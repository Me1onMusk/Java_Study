package mid2.collection.deque;

import java.util.ArrayDeque;

public class DequeStackMain {
    public static void main(String[] args) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // 데이터 추가
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println(deque);  // [3, 2, 1]

        // 다음 꺼낼 데이터 확인(꺼내지 않고 단순 조회만)
        System.out.println("deque.peek() = " + deque.peek());  // deque.peek() = 3

        // 데이터 꺼내기
        System.out.println("pop = " + deque.pop());  // 3
        System.out.println("pop = " + deque.pop());  // 2
        System.out.println("pop = " + deque.pop());  // 1
        System.out.println(deque);  // []

    }
}
