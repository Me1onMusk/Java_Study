package mid2.collection.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OfMain {
    public static void main(String[] args) {

        // 편리한 불변 컬렉션 생성
        List<Integer> list = List.of(1, 2, 3);
        Set<Integer> set = Set.of(1, 2, 3);
        Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "three");

        System.out.println("list = " + list);  // list = [1, 2, 3]
        System.out.println("set = " + set);    // set = [1, 3, 2]
        System.out.println("map = " + map);    // map = {1=one, 3=three, 2=two}
        System.out.println("list class = " + list.getClass());  // list class = class java.util.ImmutableCollections$ListN

//        list.add(4);  // java.lang.UnsupportedOperationException 발생
    }
}
