package mid1.exception.basic;

public class CheckedTest {
    public static void main(String[] args)  {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
