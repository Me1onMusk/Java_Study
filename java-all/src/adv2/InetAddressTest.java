package adv2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InetAddressTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InetAddress address1 = null;
        InetAddress address2 = null;

        System.out.print("호스트 이름을 입력하세요: ");
        String url = scanner.nextLine();

        try {
            address1 = InetAddress.getByName(url);
            address2 = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        System.out.println(address1.getHostAddress());
        System.out.println(address2.getHostAddress());

    }
}
