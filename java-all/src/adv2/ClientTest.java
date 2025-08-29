package adv2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTest {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("172.30.1.48", 5000);
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject("안녕, 서바야");
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
