package mid1.exception.ex0;


// 1. 클라이언트 연결
// 2. 해당 주소로 데이터 전송
// 3. 클라이언트 연결 해제

// 서비스 //
public class NetworkServiceV0 {
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV0 client = new NetworkClientV0(address);

        client.connect();
        client.send(data);
        client.disconnect();
    }
}
