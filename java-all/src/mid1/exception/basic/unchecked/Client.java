package mid1.exception.basic.unchecked;

public class Client {
    public void call() {
        throw new MyUncheckedException("예외 메시지");  // 예외 던지기
    }
}
