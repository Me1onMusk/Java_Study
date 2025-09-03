package start.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx2 {
    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);

        int[] nums = new int[5];
        System.out.println("5개의 정수를 입력하세요: ");
        for (int i = 0; i < nums.length; i++) {
            int num = scanner.nextInt();
            nums[i] = num;
        }

        System.out.println("출력");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if(i < nums.length-1)
                System.out.print(", ");
        }

    }
}
