package static02;

public class DecoMain02 {
    public static void main(String[] args) {

        String s = "hello java";

        System.out.println("before: " + s);
        System.out.println("after: " + DecoUtil02.deco(s));  //클래스 메서드

    }
}
