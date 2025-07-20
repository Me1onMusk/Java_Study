package chat.server;

import java.io.IOException;

public class CommandManagerV1 implements CommandManager {

    private final SessionManager sessionManager;

    public CommandManagerV1(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String allMessage, Session session) throws IOException {
        if (allMessage.startsWith("/exit"))
            throw new IOException("exit");

        sessionManager.sendAll(allMessage);
    }
}
