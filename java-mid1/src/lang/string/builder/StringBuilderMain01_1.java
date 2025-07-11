package lang.string.builder;

public class StringBuilderMain01_1 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("A");
        sb.append("B");
        sb.append("C");
        sb.append("D");
        System.out.println("sb = " + sb);

        sb.insert(4, "java");
        System.out.println("insert = " + sb);

        sb.delete(4,8);
        System.out.println("delete = " + sb);

        sb.reverse();
        System.out.println("reverse = " + sb);

        //StringBuilder(가변) -> String(불변)
        String str = sb.toString();
        System.out.println("str = " + str);

    }
}
