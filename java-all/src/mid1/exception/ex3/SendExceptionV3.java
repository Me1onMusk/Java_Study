package mid1.exception.ex3;

// Exception -> NetworkClientExceptionV3
public class SendExceptionV3 extends NetworkClientExceptionV3{

    private final String sendData;

    public SendExceptionV3(String sendData, String message) {
        super(message);
        this.sendData = sendData;
    }

    public String getSendData() {
        return sendData;
    }
}
