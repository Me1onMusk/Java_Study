package chat.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static util.MyLogger.log;

public class WriteHandler implements Runnable {

    // 쓰기 필드 //
    private static final String DELIMITER = "|";

    private final DataOutputStream output;
    private final Client client;

    private boolean closed = false;

    // 쓰기 생성자 //
    public WriteHandler(DataOutputStream output, Client client) {
        this.output = output;
        this.client = client;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        try {
            String userName = inputUserName(scanner);
            output.writeUTF("/join" + DELIMITER + userName);

            while (true) {
                String toSend = scanner.nextLine();
                if (toSend.isEmpty())
                    continue;

                if (toSend.equals("/exit")) {
                    output.writeUTF(toSend);
                    break;
                }

                // "/"로 시작하면 명령어, 나머지는 일반 메시지
                if (toSend.startsWith("/"))
                    output.writeUTF(toSend);
                else
                    output.writeUTF("/message" + DELIMITER + toSend);

            }

        } catch (IOException | NoSuchElementException e) {
            log(e);
        } finally {
            client.close();
        }

    }

    // 사용자 입력 받기 함수 //
    private static String inputUserName(Scanner scanner) {
        System.out.print("이름을 입력하세요: ");
        String userName;

        do {
            userName = scanner.nextLine();
        } while (userName.isEmpty());

        return userName;
    }

    // 닫기 //
    public synchronized void close() {
        if (closed) return;

        try {
            System.in.close();  //Scanner 입력 중지 (사용자의 입력을 닫음)
        } catch (IOException e) {
            log(e);
        }

        closed = true;
        log("[클라이언트-write] writeHandler closed");
    }
}
