package method;

public class Method01Ref01 {
    public static void main(String[] args) {
        //계산1
        int a = 1;
        int b = 2;
        System.out.println("결과1 출력: " + add(a, b));

        //계산2
        int x = 10;
        int y = 20;
        System.out.println("결과2 출력: " + add(x, y));
    }

    public static int add(int a, int b) {
        System.out.println(a + " + " + b + " 연산 수행");
        return a + b;
    }
}
