package chat.server.command;

import chat.server.Session;
import chat.server.SessionManager;

import java.io.IOException;
import java.util.List;

public class UsersCommand implements Command {

    private final SessionManager sessionManager;

    public UsersCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        List<String> allUserName = sessionManager.getAllUserName();
        StringBuilder sb = new StringBuilder();
        sb.append("전체 접속자: ").append(allUserName.size()).append("\n");
        for (String userName : allUserName) {
            sb.append(" - ").append(userName).append("\n");
        }
        session.send(sb.toString());
    }
}
