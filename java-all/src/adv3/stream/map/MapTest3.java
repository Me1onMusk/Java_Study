package adv3.stream.map;

import java.util.List;
import java.util.stream.Stream;

public class MapTest3 {
    public static void main(String[] args) {

        List<String> list1 = List.of("A", "B", "C", "D", "E");
        List<String> list2 = List.of("1", "2", "3");
        List<String> list3 = List.of("a", "b", "c");

        Stream<String> stream1 = list1.stream();           // 문자열 하나하나를 원소로 가진 스트림
        Stream<List<String>> stream2 = Stream.of(list1);   // list 전체를 원소 하나로 넣는 것
        stream2.forEach(s -> System.out.println(s.size()));

        // flatMap //
        /* multiList = [
                [A, B, C, D, E],
                [1, 2, 3],
                [a, b, c]
            ]
         */
        Stream<List<String>> multiList = Stream.of(list1, list2, list3);
        multiList.flatMap(l -> {
            if(l.size() > 4)
                return l.stream();
            else
                return Stream.empty();
        }).forEach(System.out::println);

    }
}
