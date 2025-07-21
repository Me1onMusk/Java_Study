package lambda.lambda5.mystream;

import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex1_Number {
    public static void main(String[] args) {

        // 짝수만 남기고, 남은 값의 2배를 반환
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> directResult = direct(numbers);
        System.out.println("directResult = " + directResult);

        List<Integer> lambdaResult = lambda(numbers);
        System.out.println("lambdaResult = " + lambdaResult);
    }


    // 명령형 프로그래밍 //
    static List<Integer> direct(List<Integer> numbers) {
        List<Integer> filteredList = new ArrayList<>();
        for (Integer i : numbers) {
            if (i % 2 == 0) {
                filteredList.add(i * 2);
            }
        }
        return filteredList;
    }

    // 선언적 프로그래밍 //
    static List<Integer> lambda(List<Integer> numbers) {
        List<Integer> filteredList = GenericFilter.filter(numbers, i -> i % 2 == 0);  //짝수 필터
        List<Integer> mappedList = GenericMapper.map(filteredList, i -> i * 2);       //곱하기 2
        return mappedList;
    }
}
