package mid1.exception.ex1;

public class NetworkServiceV1_2 {
    public void sendMessage(String data) {
        NetworkClientV1 client = new NetworkClientV1("http://example.com");

        client.initError(data);  // 입력 데이터 검증
        String connectResult = client.connect();

        if (isError(connectResult)) {
            System.out.println("[네트워크 오류 발생] 오류 코드: " + connectResult);
            return;
        }

        String sendResult = client.send(data);

        if (isError(sendResult)) {
            System.out.println("[네트워크 오류 발생] 오류 코드: " + sendResult);
            return;
        }

        client.disconnect();
    }

    private static boolean isError(String resultCode) {
        return !resultCode.equals("success");  // 결과 코드가 성공이 아니면 true 반환
    }
}
