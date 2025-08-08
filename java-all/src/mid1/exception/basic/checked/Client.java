package mid1.exception.basic.checked;

// 직접 만든 Checked예외 불러오기 //
public class Client {
    public void call() throws MyCheckedException {  // 외부로 예외 던지기
        throw new MyCheckedException("직접 만든 Checked 예외 메시지");  // 체크 예외 발생
    }
}
