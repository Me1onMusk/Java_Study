package adv2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("5000번 포트에 서버가 대기중...");
            Socket conn = server.accept();
            InputStream inputStream = conn.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            String message = (String) objectInputStream.readObject();
            System.out.println("받은 문자열: " + message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        
    }
}
