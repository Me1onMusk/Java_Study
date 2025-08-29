package adv2;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {
    public static void main(String[] args) {

        Socket client = null;
        PrintWriter out = null;

        // 서버와 연결 //
        try {
            client = new Socket();
            System.out.println("서버와 연결 시도중...");
            client.connect(new InetSocketAddress("172.30.1.48", 5500), 3000);
            System.out.println("서버와 연결 성공...");
        }catch (Exception e) {
            System.out.println("서버와 연결 시도 중 오류 발생...");
        }

        // 데이터 보내기 //
        Scanner scanner = new Scanner(System.in);
        try {
            out = new PrintWriter(client.getOutputStream(), true);
            String message = "";

            System.out.print("보낼 메시지가 있습니까? ");
            while((message = scanner.nextLine()) != null) {
                if(message.equals("끝")) {
                    System.out.println("클라이언트 종료");
                    out.close();
                    client.close();
                    break;
                }
                out.println(message);
                System.out.print("보낼 메시지가 있습니까?");
            }
        } catch (Exception e) {

        }

    }
}
