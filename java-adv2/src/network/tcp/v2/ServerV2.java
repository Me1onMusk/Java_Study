package network.tcp.v2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class ServerV2 {

    private static final int PORT = 12345;  //서버 포트

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);  //서버 소켓
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        Socket socket = serverSocket.accept();
        log("소캣 연결: " + socket);

        DataInputStream input = new DataInputStream(socket.getInputStream());     //서버 <- 클라이언트
        DataOutputStream output = new DataOutputStream(socket.getOutputStream()); //서버 -> 클라이언트


        while (true) {
            // 클라이언트로부터 문자 받기
            String received = input.readUTF();
            log("client -> server: " + received);
            if (received.equals("exit")) break;

            // 클라이언트에게 문자 보내기
            String toSend = received + " World!";
            output.writeUTF(toSend);
            log("client <- server: " + toSend);
        }

        // 자원 정리
        log("연결 종료:" + socket);
        input.close();
        output.close();
        socket.close();
        serverSocket.close();
    }
}
