package mid2.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        queue.add("D");
        queue.add("E");
        queue.add("F");

        while (!queue.isEmpty()){
            System.out.print(queue.poll());  // ABCDEF
        }
        System.out.println();
        System.out.println("peek = " + queue.peek());  // peek = D

    }
}
