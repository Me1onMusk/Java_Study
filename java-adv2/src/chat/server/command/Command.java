package chat.server.command;

import chat.server.Session;

import java.io.IOException;

// 디자인 패턴 : 커맨드 패턴  //
public interface Command {
    void execute(String[] args, Session session) throws IOException;
}
