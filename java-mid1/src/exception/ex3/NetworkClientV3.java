package exception.ex3;

import exception.ex3.exception.ConnectExceptionV3;
import exception.ex3.exception.NetworkClientExceptionV3;
import exception.ex3.exception.SendExceptionV3;

public class NetworkClientV3 {

    // 필드 //
    private final String address;
    public boolean connectError;
    public boolean sendError;

    // 생성자 //
    public NetworkClientV3(String address) {
        this.address = address;
    }

    // 연결 //
    public void connect() throws ConnectExceptionV3 {
        //연결 실패
        if (connectError) {
            throw new ConnectExceptionV3(address, address + " 서버 연결 실패");
        }

        //연결 성공
        System.out.println(address + " 서버 연결 성공");
    }

    // 전송 //
    public void send(String data) throws SendExceptionV3 {
        //전송 실패
        if (sendError) {
            throw new SendExceptionV3(data,address + " 서버에 데이터 전송 실패: " + data );
//            throw new RuntimeException("언체크 예외 발생");
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
