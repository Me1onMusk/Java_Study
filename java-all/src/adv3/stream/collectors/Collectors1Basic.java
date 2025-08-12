package adv3.stream.collectors;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors1Basic {
    public static void main(String[] args) {

        // 기본 기능
        // 수정 가능 리스트 반환
        List<String> list = Stream.of("Java", "Spring", "JPA")
                .collect(Collectors.toList());
        System.out.println("list = " + list);  // list = [Java, Spring, JPA]

        // 수정 불가능 리스트
        List<Integer> unmodifiableList = Stream.of(1, 2, 3)
                .collect(Collectors.toUnmodifiableList());
//        unmodifiableList.add(4); // 런타임 예외 java.lang.UnsupportedOperationException
        System.out.println("unmodifiableList = " + unmodifiableList);  // unmodifiableList = [1, 2, 3]

        Set<Integer> set = Stream.of(1, 2, 2, 3, 3, 3 )
                .collect(Collectors.toSet());
        System.out.println("set = " + set);  // set = [1, 2, 3]

        // 타입 지정
        Set<Integer> treeSet = Stream.of(3,4,5,2,1)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("treeSet = " + treeSet);  // treeSet = [1, 2, 3, 4, 5]

    }
}
