package chat.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static util.MyLogger.log;

public class SessionManager {

    private List<Session> sessions = new ArrayList<>();

    public synchronized void add(Session session) {
        sessions.add(session);
    }

    public synchronized void remove(Session session) {
        sessions.remove(session);
    }

    public synchronized void closeAll() {
        for (Session session : sessions) {
            session.close();
        }
        sessions.clear();
    }

    // 채팅 참여자 모두에게 메세지 보내기 //
    public synchronized void sendAll(String message) {
        for (Session session : sessions) {
            try {
                session.send(message);
            } catch (IOException e) {
                log(e);
            }
        }
    }

    // 모든 참여자 이름 얻기 //
    public synchronized List<String> getAllUserName() {
        List<String> usersNameList = new ArrayList<>();
        for (Session session : sessions) {
            if (session.getUsername() != null)
                usersNameList.add(session.getUsername());
        }

        return usersNameList;
    }
}
