package lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MapMainV2 {
    public static void main(String[] args) {

        List<String> list = List.of("1", "12", "123", "1234");

        // 문자열 -> 숫자
        List<Integer> numbers = map(list, s -> Integer.valueOf(s));
        System.out.println("Numbers: " + numbers);

        // 문자열 길이
        List<Integer> lengths = map(list, s -> s.length());
        System.out.println("Lengths: " + lengths);

    }

    private static List<Integer> map (List<String> list, Function<String, Integer> mapper) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : list) {
            numbers.add(mapper.apply(s));
        }
        return numbers;
    }

}
