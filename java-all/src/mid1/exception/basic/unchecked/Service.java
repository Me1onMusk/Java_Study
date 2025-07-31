package mid1.exception.basic.unchecked;

public class Service {
    Client client = new Client();

    // 예외 잡기 //
    public void callCatch() {
        try {
            client.call();
        }catch (MyUncheckedException e) {
            //예외 처리 로직
            System.out.println("예외 처리, message=" + e.getMessage());
        }
        System.out.println("정상 로직");
    }

    // 예외 던지기 //
    public void callThrow() {
        client.call();
    }
}
