package mid1.text;

import java.text.MessageFormat;

public class MessageFormatTest {
    public static void main(String[] args) {

        String java = "JAVA";
        int version = 8;

        String format = String.format("%s, %d", java, version);
        System.out.println(format);

        String mf = MessageFormat.format("{0}, {1} : {0} {0} {0}", java, version);
        System.out.println(mf);

    }
}
