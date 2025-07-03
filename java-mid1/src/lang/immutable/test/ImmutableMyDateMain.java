package lang.immutable.test;

public class ImmutableMyDateMain {
    public static void main(String[] args) {
        ImmutableMyDate date1 = new ImmutableMyDate(2025, 1, 1);
        ImmutableMyDate date2 = date1;

        System.out.println(date1);
        System.out.println(date2);

        System.out.println("1997 -> date1");

        date1 = date1.withYear(1997);

        System.out.println(date1);
        System.out.println(date2);
    }
}
