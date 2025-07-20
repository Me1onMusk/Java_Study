package lambda.lambda5.map;

import java.util.List;

import static lambda.lambda5.map.GenericMapper.*;

public class MapMainV5 {
    public static void main(String[] args) {

        List<String> fruits = List.of("apple", "banana", "orange");

        // 문자열 -> 대문자
        List<String> upperFruits = map(fruits, fruit -> fruit.toUpperCase());
        System.out.println("upperFruits: " + upperFruits);

        // 길이 반환
        List<Integer> lengthFruits = map(fruits, fruit -> fruit.length());
        System.out.println("lengthFruits: " + lengthFruits);

        // Integer -> String
        List<Integer> integers = List.of(1,2,3);
        List<String> starList = map(integers, i -> "*".repeat(i));
        System.out.println("starList: " + starList);

    }
}
