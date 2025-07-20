package chat.server;

import chat.server.command.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandManagerV3 implements CommandManager {

    private static final String DELIMITER = "\\|";
    private final Map<String, Command> commands = new HashMap<>();

    public CommandManagerV3(SessionManager sessionManager) {
        commands.put("/join", new JoinCommand(sessionManager));
        commands.put("/message", new MessageCommand(sessionManager));
        commands.put("/change", new ChangeCommand(sessionManager));
        commands.put("/users", new UsersCommand(sessionManager));
        commands.put("/exit", new ExitCommand(sessionManager));
    }

    @Override
    public void execute(String allMessage, Session session) throws IOException {
        String[] split = allMessage.split(DELIMITER);
        String key = split[0];

        Command command = commands.get(key);
        if(command == null) {
            session.send("처리할 수 없는 명령어 입니다." + allMessage);
            return;
        }
        command.execute(split, session);
    }
}
