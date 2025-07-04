package exception.basic.unchecked;

public class Client {
    public void call() {
        throw new MyUncheckedException("언체크 폭탄");
    }
}
