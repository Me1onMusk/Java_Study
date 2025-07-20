package lambda.lambda5.map;

import java.util.List;

import static lambda.lambda5.map.StringToIntegerMapper.map;

public class MapMainV4 {
    public static void main(String[] args) {

        List<String> list = List.of("1", "12", "123", "1234");

        // 문자열 -> 숫자
        List<Integer> numbers = map(list, s -> Integer.valueOf(s));
        System.out.println("Numbers: " + numbers);

        // 문자열 길이
        List<Integer> lengths = map(list, s -> s.length());
        System.out.println("Lengths: " + lengths);

    }
}
