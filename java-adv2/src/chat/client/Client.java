package chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

public class Client {

    // 클라이언트 필드 //
    private final String host;
    private final int port;

    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    private ReadHandler readHandler;
    private WriteHandler writeHandler;
    private boolean closed = false;

    // 클라이언트 생성자 //
    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    // 클라이언트 시작 //
    public void start() throws IOException {
        log("클라이언트 시작");
        socket = new Socket(host, port);
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());

        readHandler = new ReadHandler(input, this);
        writeHandler = new WriteHandler(output, this);
        Thread readThread = new Thread(readHandler, "readThread");
        Thread writeThread = new Thread(writeHandler, "writeThread");

        readThread.start();
        writeThread.start();
    }

    // 닫기 //
    public synchronized void close() {
        if (closed) return;

        readHandler.close();
        writeHandler.close();
        closeAll(socket, input, output);
        closed = true;
        log("[클라이언트] 연결 종료: " + socket);
    }
}
