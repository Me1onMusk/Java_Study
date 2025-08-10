package adv3.stream.collectors;

import java.util.List;

public class DownStreamMain1 {
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

        // 다운스트림에서 toList() 생략 가능

        // 2단계: 학년별로 학생들의 이름을 출력해라.

        // 3단계: 학년별로 학생들의 수를 출력해라.

        // 4단계: 학년별로 학생들의 평균 성적 출력해라.

    }
}
