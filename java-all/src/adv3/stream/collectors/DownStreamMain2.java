package adv3.stream.collectors;

import java.util.List;

public class DownStreamMain2 {
    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("Kim", 1, 85),
                new Student("Park", 1, 70),
                new Student("Lee", 2, 70),
                new Student("Han", 2, 90),
                new Student("Hoon", 3, 90),
                new Student("Ha", 3, 89)
        );

        // 1단계: 학년별로 학생들을 그룹화 해라.

        // 2단계: 학년별로 가장 점수가 높은 학생을 구해라. reducing 사용

        // 3단계: 학년별로 가장 점수가 높은 학생을 구해라. maxBy 사용

        // 4단계: 학년별로 가장 점수가 높은 학생의 이름을 구해라 (collectingAndThen + maxBy사용)
        // 학년별 그룹 -> 그룹별 가장 점수가 높은 학생 -> 그룹별 학생 -> 그룹별 이름

    }
}
