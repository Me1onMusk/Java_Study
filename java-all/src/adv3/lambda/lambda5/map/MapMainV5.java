package adv3.lambda.lambda5.map;

import java.util.List;

import static adv3.lambda.lambda5.map.GenericMapper.map;

public class MapMainV5 {
    public static void main(String[] args) {

        List<String> fruits = List.of("apple", "banana", "orange");

        // String -> String
        List<String> upperFruits = map(fruits, s -> s.toUpperCase());
        System.out.println(upperFruits);

        // String -> Integer
        List<Integer> lengthFruits = map(fruits, s -> s.length());
        System.out.println(lengthFruits);

        // Integer -> String
        List<Integer> integers = List.of(1, 2, 3);
        List<String> starList = map(integers, n -> "*".repeat(n));
        System.out.println(starList);

    }
}
