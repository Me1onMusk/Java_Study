package mid1.exception.ex1;

public class NetworkServiceV1_3 {
    public void sendMessage(String data) {
        NetworkClientV1 client = new NetworkClientV1("http://example.com");

        client.initError(data);  // 입력 데이터 검증
        String connectResult = client.connect();  // 연결 에러면 에러 return 반환

        if (isError(connectResult))  // 연결 오류
            System.out.println("[네트워크 오류 발생] 오류 코드: " + connectResult);
        else {
            String sendResult = client.send(data);  // 전송 에러면 에러 return 반환
            if (isError(sendResult))
                System.out.println("[네트워크 오류 발생] 오류 코드: " + sendResult);
        }

        client.disconnect();  // 연결 해제
    }

    private static boolean isError(String resultCode) {
        return !resultCode.equals("success");
    }
}
