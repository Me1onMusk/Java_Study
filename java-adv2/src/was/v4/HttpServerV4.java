package was.v4;

import was.v3.HttpRequestHandlerV3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static util.MyLogger.log;

// 서버 //
public class HttpServerV4 {

    private final ExecutorService executor = Executors.newFixedThreadPool(10);  //10개 스레드 고정
    private final int port;

    public HttpServerV4(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket  serverSocket = new ServerSocket(port);
        log("서버 시작 port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            executor.submit(new HttpRequestHandlerV4(socket));
        }
    }
}
