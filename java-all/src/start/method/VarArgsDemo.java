package start.method;

public class VarArgsDemo {
    public static void main(String[] args) {

        System.out.println(add(1,2));
        System.out.println(add(1,2,3));
        System.out.println(add(1,2,3,4));
        System.out.println(add(1,2,3,4,5));
        System.out.println(add(1,2,3,4,5,6));

    }

    // 가변 인자 //
    public static int add (int...num) {
        int sum = 0;
        for (int i : num) {
            sum += i;
        }
        return sum;
    }

}
