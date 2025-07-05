package exception.ex2;

import exception.ex1.NetworkClientV1;

public class NetworkServiceV2_1 {
    public void sendMessage(String data) throws NetworkClientExceptionV2 {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data);

        client.connect();   //연결 예외 발생 가능성
        client.send(data);  //전송 예외 발생 가능성
        client.disconnect();
    }
}
