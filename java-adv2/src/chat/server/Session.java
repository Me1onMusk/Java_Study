package chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

public class Session implements Runnable {

    // 필드 //
    private final Socket socket;
    private final DataInputStream input;
    private final DataOutputStream output;
    private final SessionManager sessionManager;
    private final CommandManager commandManager;

    private boolean closed = false;
    private String username;

    // 생성자 //
    public Session(Socket socket, CommandManager commandManager, SessionManager sessionManager) throws IOException {
        this.socket = socket;

        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());

        this.commandManager = commandManager;
        this.sessionManager = sessionManager;
        this.sessionManager.add(this);
    }

    @Override
    public void run() {
        try {
            while (true) {
                // 클라이언트로부터 문자 받기
                String received = input.readUTF();  // server <- client
                log("server <- client: " + received);

                // 메시지를 전체에게 보내기
                commandManager.execute(received, this);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            sessionManager.remove(this);
            sessionManager.sendAll(username + "님이 퇴장했습니다");
            close();
        }
    }

    // 메세지 보내기 //
    public void send(String message) throws IOException {
        log("server -> client: " + message);
        output.writeUTF(message);
    }

    // 세션 닫기 //
    public synchronized void close() {
        if (closed) return;

        closeAll(socket, input, output);
        closed = true;
        log("[서버] 연결 종료: " + socket);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
