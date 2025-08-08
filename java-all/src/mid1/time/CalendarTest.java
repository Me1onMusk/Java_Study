package mid1.time;

import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar.get(Calendar.MILLISECOND));
        System.out.println(calendar.get(Calendar.YEAR) + "년");          // 2025년
        System.out.println((calendar.get(Calendar.MONTH) + 1) + "월");   // 8월
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH) + "일");  // 8일

    }
}
