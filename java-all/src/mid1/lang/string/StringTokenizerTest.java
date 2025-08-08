package mid1.lang.string;

import java.util.StringTokenizer;

public class StringTokenizerTest {
    public static void main(String[] args) {

        String s = "J A, V, A";

        StringTokenizer st = new StringTokenizer(s, ",");
        System.out.println(st);
        System.out.println(st.countTokens());

        while(st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

    }
}
