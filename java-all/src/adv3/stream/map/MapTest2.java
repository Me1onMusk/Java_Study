package adv3.stream.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MapTest2 {
    public static void main(String[] args) {

        // 불변 리스트
        List<String> list = List.of("안녕, 자바!", "잘 가", "c++!");

        // 불변 리스트 -> 스트림
        Stream<String> stream1 = list.stream();
        stream1.forEach(System.out::println);

        // 문자열 split -> 문자열 배열[]
        // 문자열 배열[] -> 스트림
        // 스트림 forEach 출력
        String[] split = "안녕, 자바!".split(" ");
        Stream<String> stream2 = Arrays.stream(split);
        stream2.forEach(System.out::println);

        // flatMap
        Stream<String> flatMap = list.stream().flatMap(s -> Arrays.stream(s.split(" ")));
        flatMap.forEach(System.out::println);

    }
}
