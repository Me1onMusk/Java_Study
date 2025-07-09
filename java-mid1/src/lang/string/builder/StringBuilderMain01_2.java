package lang.string.builder;

public class StringBuilderMain01_2 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("A").append("B").append("C").append("D").insert(4, "java").delete(4,8).reverse();  //메서드 체이닝

        System.out.println("sb = " + sb);

        //StringBuilder(가변) -> String(불변)
        String str = sb.toString();
        System.out.println("str = " + str);

    }
}
