package adv2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest extends Thread {

    protected static boolean conn = true;
    protected Socket socket = null;

    // 생성자 //
    private ServerTest (Socket socket) {
        this.socket = socket;
        start();
    }

    // main() //
    public static void main(String[] args) {

        ServerSocket server = null;

        try {
            server = new ServerSocket(5500);
            while(conn) {
                System.out.println("");
                new ServerTest(server.accept());
                System.out.println();
            }
            server.close();
        } catch (Exception e) {
            System.out.println("");
        }

    }

    public void run() {
        BufferedReader in =  null;

        System.out.println("클라이언트와 통신을 위한 새로운 스레드 생성...");

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message = "";

            while((message = in.readLine()) != null) {
                if(message.contains("끝")) {
                    in.close();
                    socket.close();
                    break;
                }
                System.out.println("읽은 메시지: " + message);
            }
        } catch (Exception e) {

        }

    }

}
