package mid1.exception.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithResource {
    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("file.txt")) {

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("파일을 찾지 못했습니다.");
        } catch (IOException e) {
            System.out.println("파일 입출력 오류");
        }

        try (Resource r = new Resource()) {
            r.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

// 자원 종료 자동 //
class Resource implements AutoCloseable {
    void show() {
        System.out.println("리소스를 사용합니다.");
    }
    @Override
    public void close() throws Exception {
        System.out.println("리소스를 닫습니다.");
    }
}