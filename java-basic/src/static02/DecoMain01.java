package static02;

public class DecoMain01 {
    public static void main(String[] args) {

        String s = "hello java";
        DecoUtil01 utils = new DecoUtil01();

        System.out.println("before: " + s);
        System.out.println("after: " + utils.deco(s));

    }
}
