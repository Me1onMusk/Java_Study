package mid2.collection.set;

import java.util.HashMap;
import java.util.Map;

public class HashSetTest {
    public static void main(String[] args) {

        Map<String, Integer> map = Map.of("사과", 5, "바나나", 2, "포도", 10);
        Map<String, Integer> fruits = new HashMap<>(map);

        fruits.put("사과", 3);
        fruits.put("딸기", 6);
        System.out.println(fruits.size());    // 4
        System.out.println(fruits.keySet());  // [사과, 포도, 바나나, 딸기]
        System.out.println(fruits.values());  // [3, 10, 2, 6]

    }
}
