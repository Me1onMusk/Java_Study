package optional;

import java.util.Optional;

public class OptionalCreationMain {
    public static void main(String[] args) {

        // 1. of() : 값이 null이 아님이 확실할 때 사용, null이면 NullPointerException 발생
        String nonNullvalue = "Hello Optional";
        Optional<String> opt1 = Optional.of(nonNullvalue);
        System.out.println("opt1 = " + opt1);

        // 2. ofNullable() : 값이 null일 수도 아닐 수도 있을 때
        Optional<String> opt2 = Optional.ofNullable("Hello!");
        Optional<Object> opt3 = Optional.ofNullable(null);
        System.out.println("opt2 = " + opt2);
        System.out.println("opt3 = " + opt3);

        // 3. empty() : 비어있는 Optional을 명시적으로 생성
        Optional<Object> opt4 = Optional.empty();
        System.out.println("opt4 = " + opt4);

    }
}
