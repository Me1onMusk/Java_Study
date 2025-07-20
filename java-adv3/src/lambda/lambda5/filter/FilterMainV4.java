package lambda.lambda5.filter;

import java.util.List;

import static lambda.lambda5.filter.IntegerFilter.filter;

public class FilterMainV4 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 짝수만 거르기
        List<Integer> filteredEven = filter(numbers, x -> x % 2 == 0);
        System.out.println("Even numbers: " + filteredEven);

        //홀수만 거르기
        List<Integer> filteredOdd = filter(numbers, x -> x % 2 != 0);
        System.out.println("Odd numbers: " + filteredOdd);
    }
}
