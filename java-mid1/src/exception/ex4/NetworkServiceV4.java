package exception.ex4;

public class NetworkServiceV4 {
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV4 client = new NetworkClientV4(address);
        client.initError(data);

        try {
            client.connect();   //연결 예외 발생 가능성
            client.send(data);  //전송 예외 발생 가능성
        } finally {
            client.disconnect();
        }

    }
}
