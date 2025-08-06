package mid2.collection.deque;

import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        // 3
        // 2
        // 1
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);

        // 다음 꺼낼 요소 확인(꺼내지 않고 단순 조회만)
        // 3
        System.out.println("stack.peek() = " + stack.peek());

        // 스택 요소 뽑기
        System.out.println("stack.pop() = " + stack.pop());  // 3
        System.out.println("stack.pop() = " + stack.pop());  // 2
        System.out.println("stack.pop() = " + stack.pop());  // 1
        System.out.println(stack);

    }
}
