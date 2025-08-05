package adv2.io.start;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayStreamMain {
    public static void main(String[] args) throws IOException {

        byte[] data = {65, 66, 67};

        ByteArrayOutputStream baos = new ByteArrayOutputStream();  // 메모리에 쓰기
        baos.write(data);
        baos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());  // 메모리에 읽기
        byte[] read = bais.readAllBytes();
        System.out.println(Arrays.toString(read));  // [65, 66, 67]
        bais.close();

    }
}
