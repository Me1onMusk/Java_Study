package chat.server;

import java.io.IOException;

public interface CommandManager {
    void execute(String allMessage, Session session) throws IOException;
}
