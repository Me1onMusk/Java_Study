package mid1.exception.basic.checked;

// Exception 예외 상속
// 직접 만든 Checked예외 //
public class MyCheckedException extends Exception {
    public MyCheckedException(String message) {
        super(message);
    }
}
