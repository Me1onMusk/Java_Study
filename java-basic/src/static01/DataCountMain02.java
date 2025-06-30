package static01;

public class DataCountMain02 {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Data02 data01 = new Data02("A", counter);
        System.out.println("A count: " + counter.count);

        Data02 data02 = new Data02("B", counter);
        System.out.println("B count: " + counter.count);

        Data02 data03 = new Data02("C", counter);
        System.out.println("C count: " + counter.count);
    }
}
