package lambda.lambda5.mystream;

import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMapper;

import java.util.ArrayList;
import java.util.List;

public class Ex2_Student {
    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("Apple", 100),
                new Student("Banana", 80),
                new Student("Berry", 50),
                new Student("Tomato", 48)
        );

        List<String> directResult = direct(students);
        System.out.println("directResult = " + directResult);

        List<String> lambdaResult = lambda(students);
        System.out.println("lambdaResult = " + lambdaResult);

    }

    // 명령형 프로그래밍 //
    private static List<String> direct(List<Student> students) {
        List<String> directResult = new ArrayList<>();

        for (Student student : students) {
            if(student.getScore() >= 80)
                directResult.add(student.getName());
        }

        return directResult;
    }

    // 선언적 프로그래밍 //
    private static List<String> lambda(List<Student> students) {
        List<Student> filter = GenericFilter.filter(students, s -> s.getScore() >= 80);  //점수가 80점 이상인 학생들만 필터
        List<String> map = GenericMapper.map(filter, s -> s.getName());                  //필터링된 학생 객체에서 이름만 추출
        return map;
    }
}
