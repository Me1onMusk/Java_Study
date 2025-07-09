package lang.math.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class LottoGenerator {

    private final Random random = new Random();
    private int[] lottoNumbers;
    private int count;

    public int[] generate() {
        lottoNumbers = new int[6];
        count = 0;

        while (count < 6) {
            // 1부터 45 사이의 숫자 생성
            int number = random.nextInt(45) + 1;

            // 종복되지 않은 경우에만 배열에 추가
            if (isUnique(number))
                lottoNumbers[count++] = number;
        }

        return lottoNumbers;
    }

    private boolean isUnique(int number) {
        for (int i = 0; i < count; i++) {
            if (lottoNumbers[i] == number)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("로또 번호: " + Arrays.toString(new LottoGenerator().generate()));
    }

}
