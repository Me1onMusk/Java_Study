package network.tcp.v5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

public class ClientV5 {

    private static final int PORT = 12345;  //서버 포트

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");

        try (Socket socket = new Socket("localhost", PORT);
             DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {

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
        }

    }
}
