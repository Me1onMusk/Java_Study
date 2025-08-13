package mid2.collection;

import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("점수를 입력하세요: ");
                int score = Integer.parseInt(scanner.nextLine());
                if (score == -1) break;
                list.add(score);
            } catch (NumberFormatException e) {
                System.out.println("올바른 점수를 입력하세요.");
            }
        }
        System.out.println("전체 학생은 " + list.size() + "명이다.");

        Collections.sort(list, Collections.reverseOrder());
        int max = list.get(0);
        String grade;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max - 10)
                grade = "A";
            else if (list.get(i) > max - 20)
                grade = "B";
            else
                grade = "C";
            System.out.println(i + "번 학생의 점수는 " + list.get(i) + "이고 등급은 " + grade + "입니다.");
        }
    }
}
