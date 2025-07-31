package mid1.exception.ex2;

public class NetworkClientV2 {

    private final String address;  // 초기값 0
    public boolean connectError;   // 초기값 false
    public boolean sendError;      // 초기값 false

    public NetworkClientV2(String address) {
        this.address = address;
    }

    // 서버 연결 //
    public void connect() throws NetworkClientExceptionV2 {
        if (connectError)  // 연결 에러 발생 시 에러 객체 생성 & 에러 던지기
            throw new NetworkClientExceptionV2("connectError", address + " 서버 연결 실패");
        // 서버 연결 성공
        System.out.println(address + " 서버 연결 성공");
    }

    // 데이터 전송 //
    public void send(String data) throws NetworkClientExceptionV2 {
        if(sendError)
            throw new NetworkClientExceptionV2("sendError", address + " 서버에 데 이터 전송 실패: " + data);
        // 데이터 전송 성공
        System.out.println(address + " 서버에 데이터 전송: " + data);
    }

    public void disconnect() {
        System.out.println(address + " 서버 연결 해제");
    }

    public void initError(String data) {
        if (data.contains("error1")) connectError = true;
        if (data.contains("error2")) sendError = true;
    }

}
