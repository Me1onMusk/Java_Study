package adv1.thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

public class BoundedQueueV4 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV4(int max) {
        this.max = max;
    }

    @Override
    public void put(String data) {

    }

    @Override
    public String take() {
        return "";
    }

}
