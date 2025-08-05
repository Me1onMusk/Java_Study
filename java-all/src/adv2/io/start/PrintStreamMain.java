package adv2.io.start;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.*;

public class PrintStreamMain {
    public static void main(String[] args) throws IOException {

        PrintStream printStream = System.out;  // 콘솔에 출력

        byte[] data = "Hello\n".getBytes(UTF_8);
        printStream.write(data);
        printStream.println("Print!");

    }
}
