package mid1.exception.basic;

public class UnCheckedTest {
    public static void main(String[] args) {

        // java.lang.ArithmeticException //
//        int res = 5 / 0;
//        System.out.println(res);

        try {
            int res = 5 / 0;
            System.out.println(res);
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
            System.out.println("0으로 나눌 수 없습니다. \n");
        }

        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("NullPointException 발생 \n");
        }

        try {
            int[] arr = new int[0];
            System.out.println(arr[3]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
