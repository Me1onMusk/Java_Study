package mid1.exception.basic.checked;

public class Service {

    Client client = new Client();

    // 예외 잡기 //
    public void callCatch() {
        try {
            client.call();  // 예외 발생 -> 1.예외 잡기 (trt ~ catch) 2.예외 던지기
        } catch (MyCheckedException e) {  // 부모 Exception 체크드 예외 발생
            System.out.println("예외 처리, message= " + e.getMessage());
        }
        System.out.println("정상 흐름");
    }

    // 예외 던지기 //
    public void callThrow() throws MyCheckedException {
        client.call();
    }

}
