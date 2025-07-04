package exception.ex0;

public class NetworkClientV0 {
    private final String address;

    // 생성자 //
    public NetworkClientV0(String address) {
        this.address = address;
    }

    // 연결 //
    public String connect() {
        //연결 성공
        System.out.println(address + " 서버 연결 성공");
        return "success";
    }

    // 전송 //
    public String send(String data) {
        //전송 성공
        System.out.println(address + " 서버에 데이터 전송: " + data);
        return "success";
    }

    // 연결 해제 //
    public void disconnect() {
        System.out.println(address + " 서버 연결 해제");
    }
}
