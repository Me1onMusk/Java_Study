package adv2.io.start;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain3 {
    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        byte[] data = {65, 66, 67};
        fos.write(data);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        byte[] buffer = new byte[10];                 // 10byte 사이즈 버퍼
        int read = fis.read(buffer, 0, 10);  //
        System.out.println("read = " + read);         // read = 3
        System.out.println(Arrays.toString(buffer));  // [65, 66, 67, 0, 0, 0, 0, 0, 0, 0]
        fis.close();

    }
}
