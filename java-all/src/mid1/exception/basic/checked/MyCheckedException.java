package mid1.exception.basic.checked;

// Exception 예외 상속
public class MyCheckedException extends Exception {
    public MyCheckedException(String message) {
        super(message);
    }
}
