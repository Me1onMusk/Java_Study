package lang.wrapper.test;

public class WrapperTest3 {
    public static void main(String[] args) {

        String str = "100";

        // String -> Integer
        // valueOf : 객체 (참조형)
        Integer integer1 = Integer.valueOf(str);
        System.out.println("integer1 = " + integer1);

        // Integer -> int (언박싱)
        // intValue : 기본형
        int i = integer1.intValue();
        System.out.println("i = " + i);

        // int -> Integer (박싱)
        Integer integer2 = Integer.valueOf(i);
        System.out.println("integer2 = " + integer2);
    }
}
