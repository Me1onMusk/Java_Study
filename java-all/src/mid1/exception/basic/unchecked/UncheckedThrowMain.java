package mid1.exception.basic.unchecked;

public class UncheckedThrowMain {
    public static void main(String[] args) throws MyUncheckedException {

        Service service = new Service();
        service.callThrow();
        System.out.println("정상 종료");

    }
}
