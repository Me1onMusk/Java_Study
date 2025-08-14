package mid2.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 이진 탐색 //
// 1. 정렬
// 2. 탐색
public class BinarySort {
    public static void main(String[] args) {

        List<String> list = List.of("사과", "포도", "수박", "키위", "망고", "사과");
        List<String> fruits = new ArrayList<>(list);

        Collections.sort(fruits);

        System.out.println(Collections.binarySearch(fruits, "포도"));              // 5
        System.out.println(fruits.get(Collections.binarySearch(fruits, "포도")));  // 포도

    }
}
