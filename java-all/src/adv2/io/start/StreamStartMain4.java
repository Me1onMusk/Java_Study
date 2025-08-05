package adv2.io.start;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain4 {
    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        byte[] data = {65, 66, 67};
        fos.write(data);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        byte[] read = fis.readAllBytes();           // 모든 바이트 한번에 읽기
        System.out.println(Arrays.toString(read));  // [65, 66, 67]
        fis.close();

    }
}
