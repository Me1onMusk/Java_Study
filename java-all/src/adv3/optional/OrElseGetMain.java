package adv3.optional;

public class OrElseGetMain {
    public static void main(String[] args) {

        System.out.println("단순 계산");

        // 값이 있으면 그 값, 없으면 지정된 기본값 사용
        System.out.println("=== orElse ===");
        System.out.println("값이 있는 경우");

        System.out.println("값이 없는 경우");

        // 값이 있으면 그 값, 없으면 지정된 람다 사용
        System.out.println("=== orElseGet ===");
        System.out.println("값이 있는 경우");

        System.out.println("값이 없는 경우");

    }

    public static int createData() {
        return 0;
    }

}
