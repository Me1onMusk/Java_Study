package exception.ex2;

public class NetworkServiceV2_5 {
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data);

        try {
            client.connect();   //연결 예외 발생 가능성
            client.send(data);  //전송 예외 발생 가능성
        } catch (NetworkClientExceptionV2 e) {
            System.out.println("[오류] 코드 = " + e.getErrorCode() + ", 메시지 = " + e.getMessage());
        } finally {
            client.disconnect();
        }

    }
}
