package thread.control;

import static util.ThreadUtils.sleep;

public class CheckedExceptionMain {
    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    static class CheckedException implements Runnable {
        @Override
        public void run() /*throws Exception*/ {
//            throw new Exception();  //주석 풀면 예외 발생
            sleep(1000);
        }
    }
}
