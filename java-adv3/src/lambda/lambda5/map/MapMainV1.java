package lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;

public class MapMainV1 {
    public static void main(String[] args) {

        List<String> list = List.of("1", "12", "123", "1234");

        // 문자열 -> 숫자
        List<Integer> numbers = mapStringToInteger(list);
        System.out.println("Numbers: " + numbers);

        // 문자열 길이
        List<Integer> lengths = mapStringToLength(list);
        System.out.println("Lengths: " + lengths);

    }

    private static List<Integer> mapStringToInteger(List<String> list) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : list) {
            Integer value = Integer.valueOf(s);  //String -> Integer(객체)
            numbers.add(value);
        }
        return numbers;
    }

    private static List<Integer> mapStringToLength(List<String> list) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : list) {
            numbers.add(s.length());
        }
        return numbers;
    }
}
