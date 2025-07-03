package lang.immutable.test;

public class MyDateMain {
    public static void main(String[] args) {
        MyDate date1 = new MyDate(2025, 1, 1);
        MyDate date2 = date1;

        System.out.println(date1);
        System.out.println(date2);

        System.out.println("2025 -> 1997");
        date1.setYear(1997);

        System.out.println(date1);
        System.out.println(date2);
    }
}
