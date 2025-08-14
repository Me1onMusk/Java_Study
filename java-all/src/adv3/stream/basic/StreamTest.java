package adv3.stream.basic;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {

        String[] sArr = { "a", "b", "c" ,"d", "e"};
        Stream<String> arrStream = Arrays.stream(sArr);
        Stream<String> stream = Stream.of(sArr);

        double[] dArr = { 1.0, 2.9, 3.0, 4.2, 5.3};
        DoubleStream dStream = DoubleStream.of(dArr);

        Random random = new Random();
        IntStream ints = random.ints(0, 10);  // 0 ~ 9
        ints.limit(10).forEach(System.out::println);

        IntStream range = IntStream.range(1, 10);  // 1 ~ 9
        range.forEach(System.out::println);

        IntStream iterate = IntStream.iterate(1, i -> i + 10);
        iterate.limit(10).forEach(System.out::println);

    }
}
