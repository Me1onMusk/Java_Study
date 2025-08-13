package mid2.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/*
    Collection
        1. List
            - LinkedList
            - ArrayList
        2. Queue
        3. Set
            - HashSet
            - TreeSet
 */

public class IteratorTest {
    public static void main(String[] args) {

        // 문자열 배열(불변)
        String[] arr = {"1", "2", "3"};

        // Array(가변) -> List(고정) -> Array(가변)
        Collection<String> list = new ArrayList<>(Arrays.asList("다람쥐", "개구리", "나비"));
        list.add("라마");
        list.add("나비");

        System.out.println(list.size());

        // 삭제 //
        list.remove("나비");

        // 순회 //
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
