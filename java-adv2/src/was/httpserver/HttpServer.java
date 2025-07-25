package was.httpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static util.MyLogger.log;

public class HttpServer {

    private final ExecutorService executor = Executors.newFixedThreadPool(10);  //10개 스레드 고정
    private final int port;
    private final ServletManager servletManager;

    public HttpServer(int port,  ServletManager servletManager) {
        this.port = port;
        this.servletManager = servletManager;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        log("서버 시작 port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            executor.submit(new HttpRequestHandler(socket, servletManager));
        }
    }
}
