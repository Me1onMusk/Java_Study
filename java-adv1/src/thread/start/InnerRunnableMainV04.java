package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV04 {
    public static void main(String[] args) {
        log("main() start");
        
        //람다
        Thread thread = new Thread(() -> log("MyRunnable run()"));
        thread.start();

        log("main() end");
    }
}
