package mid1.lang.string.builder;

public class StringBuilderMain1_1 {
    public static void main(String[] args) {

        // append() //
        StringBuilder sb = new StringBuilder();
        sb.append("A");
        sb.append("B");
        sb.append("C");
        sb.append("D");
        System.out.println("sb = " + sb);  // sb = ABCD

        // insert() //
        sb.insert(4, "Java");
        System.out.println("insert = " + sb);  // insert = ABCDJava

        // delete () //
        sb.delete(4, 8);
        System.out.println("delete = " + sb);  // delete = ABCD

        // reverse() //
        sb.reverse();
        System.out.println("reverse = " + sb);  // reverse = DCBA

        // StringBuilder -> String
        String string = sb.toString();
        System.out.println("string = " + string);  // string = DCBA

    }
}
