package adv3.lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterMainV2 {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 짝수만 거르기
        List<Integer> evenNumbers = filter(numbers, i -> i % 2 == 0);
        System.out.println("evenNumbers = " + evenNumbers);  // evenNumbers = [2, 4, 6, 8, 10]

        // 홀수만 거르기
        List<Integer> oddNumbers = filter(numbers, i -> i % 2 != 0);
        System.out.println("oddNumbers = " + oddNumbers);  // oddNumbers = [1, 3, 5, 7, 9]

    }

    static List<Integer> filter(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                filtered.add(number);
            }
        }
        return filtered;
    }

}
