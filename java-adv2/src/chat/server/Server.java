package chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class Server {

    // 서버 필드 //
    private final int port;
    private final CommandManager commandManager;
    private final SessionManager sessionManager;

    private ServerSocket serverSocket;

    // 서버 생성자 //
    public Server(int port, CommandManager commandManager, SessionManager sessionManager) {
        this.port = port;
        this.commandManager = commandManager;
        this.sessionManager = sessionManager;
    }

    // 서버 시작 함수 //
    public void start() throws IOException {
        log("서버 시작: " + commandManager.getClass());
        serverSocket = new ServerSocket(port);
        log("서버 소켓 시작 - 리스닝 포트: " + port);

        // 셧 다운 훅 등록
        addShutdownHook();

        // 프로그램 작동 (정상 흐름)
        running();
    }

    // 실행 함수 //
    private void running() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();  //블로킹
                log("소캣 연결: "+socket);

                Session session = new Session(socket, commandManager, sessionManager);
                Thread thread = new Thread(session);
                thread.start();
            }
        } catch (IOException e) {
            log("서버 소캣 종료: " + e);
        }
    }

    // 셧다운훅 등록 함수 //
    private void addShutdownHook() {
        ShutdownHook shutdownHook = new ShutdownHook(serverSocket, sessionManager);
        Runtime.getRuntime().addShutdownHook(new Thread(shutdownHook, "ShutdownHook"));
    }

    // Hook //
    static class ShutdownHook implements Runnable{

        // 필드 //
        private final ServerSocket serverSocket;
        private final SessionManager sessionManager;

        // 생성자 //
        public ShutdownHook(ServerSocket serverSocket, SessionManager sessionManager){
            this.serverSocket = serverSocket;
            this.sessionManager = sessionManager;
        }

        @Override
        public void run() {
            log("shutdownHook 실행");
            try {
                sessionManager.closeAll();
                serverSocket.close();
                
                Thread.sleep(1000); // 자원 정리 대기
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("e = " + e);
            }
        }
    }

}
