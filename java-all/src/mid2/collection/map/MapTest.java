package mid2.collection.map;

import java.util.Map;

public class MapTest {
    public static void main(String[] args) {

        Map<String, Integer> fruits = Map.of("사과", 5, "바나나", 2, "포도", 10);

        System.out.println(fruits.size());
        System.out.println(fruits.keySet());
        System.out.println(fruits.values());

        System.out.println(fruits.containsKey("사과"));

    }
}
