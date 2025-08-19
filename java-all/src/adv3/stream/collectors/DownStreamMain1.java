package adv3.stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        Map<Integer, List<Student>> collect1_1 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,   // 그룹화 기준: 학년
                        Collectors.toList()  // 다운스트림1: 학생을 리스트로 수집
                ));
        System.out.println("collect1_1 = " + collect1_1);
        // collect1_1 = {1=[Student{name='Kim', grade=1, score=85}, Student{name='Park', grade=1, score=70}], 2=[Student{name='Lee', grade=2, score=70}, Student{name='Han', grade=2, score=90}], 3=[Student{name='Hoon', grade=3, score=90}, Student{name='Ha', grade=3, score=89}]}

        // 다운스트림에서 toList() 생략 가능.
        Map<Integer, List<Student>> collect1_2 = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));
        System.out.println("collect1_2 = " + collect1_2);
        // collect1_2 = {1=[Student{name='Kim', grade=1, score=85}, Student{name='Park', grade=1, score=70}], 2=[Student{name='Lee', grade=2, score=70}, Student{name='Han', grade=2, score=90}], 3=[Student{name='Hoon', grade=3, score=90}, Student{name='Ha', grade=3, score=89}]}

        // 2단계: 학년별로 학생들의 이름을 출력해라.
        Map<Integer, List<String>> collect2 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,  // 그룹화 기준: 학년
                        Collectors.mapping(
                                Student::getName,    // // 다운스트림 1: 학생
                                Collectors.toList()  // 다운스트림 2: 변환된 값(이름)
                        )
                ));
        System.out.println("collect2 = " + collect2);
        // collect2 = {1=[Kim, Park], 2=[Lee, Han], 3=[Hoon, Ha]}

        // 3단계: 학년별로 학생들의 수를 출력해라.
        Map<Integer, Long> collect3 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.counting()
                ));
        System.out.println("collect3 = " + collect3);
        // collect3 = {1=2, 2=2, 3=2}

        // 4단계: 학년별로 학생들의 평균 성적 출력해라.
        Map<Integer, Double> collect4 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.averagingInt(Student::getScore)
                ));
        System.out.println("collect4 = " + collect4);
        // collect4 = {1=77.5, 2=80.0, 3=89.5}

    }
}
