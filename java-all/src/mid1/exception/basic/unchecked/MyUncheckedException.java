package mid1.exception.basic.unchecked;

// RuntimeException 상속 //
public class MyUncheckedException extends RuntimeException{
    public MyUncheckedException(String message) {
        super(message);
    }
}
