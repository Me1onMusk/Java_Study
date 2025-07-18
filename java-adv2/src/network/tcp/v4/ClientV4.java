package network.tcp.v4;

import network.tcp.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static network.tcp.SocketCloseUtil.*;
import static util.MyLogger.log;

public class ClientV4 {

    private static final int PORT = 12345;  //서버 포트

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");

        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;

        try {
            socket = new Socket("localhost", PORT);  //내 localhost IP & 랜덤 localhost port -> 서버 포트 접근
            input = new DataInputStream(socket.getInputStream());      //클라이언트 <- 서버
            output = new DataOutputStream(socket.getOutputStream());  //클라이언트 -> 서버
            log("소캣 연결: " + socket);

            // 서버에게 문자 보내기
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("전송문자: ");
                String toSend = scanner.nextLine();
                output.writeUTF(toSend);

                if (toSend.equals("exit")) break;

                // 서버로부터 문자 받기
                String received = input.readUTF();
                System.out.println("받은문자: " + received);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            closeAll(socket, input, output);
            log("연결 종료: " + socket);
        }

    }
}
