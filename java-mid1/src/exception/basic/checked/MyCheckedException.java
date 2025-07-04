package exception.basic.checked;

// Exception을 상속 받은 예외는 체크 예외가 된다.
// 폭탄 생성 //
public class MyCheckedException extends Exception{
    public MyCheckedException(String message) {
        super(message);
    }
}
