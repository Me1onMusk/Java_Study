package mid1.text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    public static void main(String[] args) {

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        System.out.println(sdf.format(date));

    }
}
