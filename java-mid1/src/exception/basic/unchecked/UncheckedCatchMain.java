package exception.basic.unchecked;

import exception.basic.checked.MyCheckedException;

public class UncheckedCatchMain {
    public static void main(String[] args) {
        Service service = new Service();
//        service.callCatch();
        service.catchThrow();
        System.out.println("정상흐름");
    }
}
