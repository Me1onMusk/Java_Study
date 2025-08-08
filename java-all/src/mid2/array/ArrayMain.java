package mid2.array;

import java.util.Arrays;

public class ArrayMain {
    public static void main(String[] args) {

        String[] arr = {"케이크", "애플", "도넛", "바나나"};
        Integer[] arr2 = {1, 2, 3, 4};
        Character[] arr3 = {'J', 'A', 'V', 'A'};

        // 출력 //
        printArray(arr);
        printArray(arr2);
        printArray(arr3);

        // 정렬 //
        Arrays.sort(arr);
        printArray(arr);

        // 이진탐색 //
        System.out.println(Arrays.binarySearch(arr, "애플"));

    }

    static void printArray(Object[] arr) {
        System.out.print("[ ");
        for(Object s : arr) {
            System.out.print(s + " ");
        }
        System.out.print(" ] \n");
    }
}
