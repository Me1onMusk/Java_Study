package mid1.time;


import java.time.LocalDate;

public class LocalDateMain {
    public static void main(String[] args) {

        LocalDate nowDate = LocalDate.now();
        LocalDate ofDate =  LocalDate.of(2025,8,1);

        System.out.println(nowDate);
        System.out.println(ofDate);

        LocalDate plusDate = ofDate.plusDays(7);
        System.out.println(plusDate);

    }
}
