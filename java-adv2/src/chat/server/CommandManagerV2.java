package chat.server;

import java.io.IOException;
import java.util.List;

public class CommandManagerV2 implements CommandManager {

    private static final String DELIMITER = "\\|";
    private final SessionManager sessionManager;

    public CommandManagerV2(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String allMessage, Session session) throws IOException {

        if(allMessage.startsWith("/join")) {
            String[] split = allMessage.split(DELIMITER);
            String userName = split[1];
            session.setUsername(userName);
            sessionManager.sendAll(userName + "님이 입장했습니다.");

        } else if (allMessage.startsWith("/message")) {
            String[] split = allMessage.split(DELIMITER);
            String message = split[1];
            sessionManager.sendAll("[" + session.getUsername()+"] : " +  message);

        } else if (allMessage.startsWith("/change")) {
            String[] split = allMessage.split(DELIMITER);
            String changeName =  split[1];
            sessionManager.sendAll(session.getUsername()+"님이 "+changeName+"로 이름을 변경습니다.");
            session.setUsername(changeName);

        } else if (allMessage.startsWith("/users")) {
            List<String> allUserName = sessionManager.getAllUserName();
            StringBuilder sb = new StringBuilder();
            sb.append("전체 접속자: ").append(allUserName.size()).append("\n");
            for (String userName : allUserName) {
                sb.append(" - ").append(userName).append("\n");
            }
            session.send(sb.toString());
        }else if (allMessage.startsWith("/exit")) {
            throw new IOException("exit");
        }
        else
            session.send("처리할 수 없는 명령어 입니다." + allMessage);
    }
}
