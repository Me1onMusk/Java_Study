package chat.client;

import java.io.DataInputStream;
import java.io.IOException;

import static util.MyLogger.log;

public class ReadHandler implements Runnable {

    // 읽기 필드 //
    private final DataInputStream input;
    private final Client client;
    public boolean closed = false;

    // 읽기 생성자 //
    public ReadHandler(DataInputStream input, Client client) {
        this.input = input;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = input.readUTF();  //client <- server
                System.out.println(received);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            client.close();
        }
    }

    // 닫기
    public synchronized void close() {
        if (closed) return;
        
        // 종료 로직 필요시 작성
        closed = true;
        log("[클라이언트-read] readHandler 종료");
    }

}
