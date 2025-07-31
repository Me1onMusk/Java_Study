package mid1.exception.ex1;

// 네트워크 클라이언트 //
public class NetworkClientV1 {

    private final String address;
    public boolean connectError;
    public boolean sendError;

    // 생성자 //
    public NetworkClientV1(String address) {
        this.address = address;
    }

    // 연결 //
    public String connect() {
        if (connectError) {
            System.out.println(address + " 서버 연결 실패");
            return "connectError";
        }

        // 연결 성공
        System.out.println(address + " 서버 연결 성공");
        return address;
    }

    // 전송 //
    public String send(String data) {
        // 전송 실패
        if (sendError) {
            System.out.println(address + " 서버에 데이터 전송 실패 : " + data);
            return "sendError";
        }
        // 전송 성공
        System.out.println(address + " 서버에 데이터 전송 " + data);
        return "success";
    }

    // 연결 해제 //
    public void disconnect() {
        System.out.println(address + " 서버 연결 해제");
    }

    // 일부러 초기 에러 만들기 //
    public void initError(String data) {
        // 연결 에러
        if (data.contains("error1")) connectError = true;

        // 전송 에러
        if (data.contains("error2")) sendError = true;
    }
}
