package exception.ex1;

public class NetworkServiceV1_3 {
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data);

        String connectResult = client.connect();
        if(isError(connectResult)) {
            System.out.println("[네트워크 오류 발생] 오류 코드: " + connectResult);
        } else {
            String sendResult = client.send(data);
            if(isError(sendResult)) {
                System.out.println("[네트워크 오류 발생]오류 코드: " + sendResult);
            }
        }

        client.disconnect();  //성공해든 실패하든 반드시 한번은 실행 되어야 함.
    }

    private static boolean isError(String connectResult) {
        return !connectResult.equals("success");
    }
}
