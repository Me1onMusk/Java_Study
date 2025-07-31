package adv1.thread.start;

public class BadThreadMain {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + ": main() start");

        System.out.println(Thread.currentThread().getName() + ": run() 호출 전");
        HelloThread helloThread = new HelloThread();
        helloThread.run();
        System.out.println(Thread.currentThread().getName() + ": run() 호출 후");

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }
}
