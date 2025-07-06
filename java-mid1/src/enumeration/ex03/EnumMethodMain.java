package enumeration.ex03;

import java.util.Arrays;

public class EnumMethodMain {
    public static void main(String[] args) {

        // 모든 Enum 반환
        Grade[] values = Grade.values();
        System.out.println("values: " + Arrays.toString(values));
        for (Grade grade : values) {
            System.out.println("name = " + grade.name() + ", ordinal = " + grade.ordinal());
        }

        // String -> Enum 변환 / 잘못된 문자면 IllegalArgumentException 발생
        String input = "GOLD";
        Grade gold = Grade.valueOf(input);
        System.out.println("gold: " + gold);
    }
}
