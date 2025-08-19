package adv3.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MatchTest {
    public static void main(String[] args) {

        // antMatch //
        boolean anyMatch = Stream.of("a1", "b1", "c1", "d1")
                .anyMatch(s -> s.startsWith("c"));
        System.out.println("anyMatch = " + anyMatch);

        // allMatch //
        boolean allMatch = IntStream.of(10, 20, 30)
                .allMatch(n -> n % 10 == 0);
        System.out.println("allMatch = " + allMatch);


    }
}
