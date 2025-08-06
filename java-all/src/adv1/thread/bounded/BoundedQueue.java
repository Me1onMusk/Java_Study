package adv1.thread.bounded;

// 버퍼 = 창고 //
public interface BoundedQueue {
    void put(String data);
    String take();
}
