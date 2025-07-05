package exception.ex2;

public class NetworkClientV2 {

    // 필드 //
    private final String address;
    public boolean connectError;
    public boolean sendError;

    // 생성자 //
    public NetworkClientV2(String address) {
        this.address = address;
    }

    // 연결 //
    public void connect() throws NetworkClientExceptionV2 {
        //연결 실패
        if (connectError) {
            throw new NetworkClientExceptionV2("connectError", address + " 서버 연결 실패");
        }

        //연결 성공
        System.out.println(address + " 서버 연결 성공");
    }

    // 전송 //
    public void send(String data) throws NetworkClientExceptionV2 {
        //전송 실패
        if (sendError) {
//            throw new NetworkClientExceptionV2("sendError"," 서버에 데이터 전송 실패: " + data );
            throw new RuntimeException("언체크 예외 발생");
        }

        //전송 성공
        System.out.println(address + " 서버에 데이터 전송: " + data);
    }

    // 연결 해제 //
    public void disconnect() {
        System.out.println(address + " 서버 연결 해제");
    }

    public void initError(String data) {
        if (data.contains("error1"))
            connectError = true;
        if (data.contains("error2"))
            sendError = true;
    }
}
