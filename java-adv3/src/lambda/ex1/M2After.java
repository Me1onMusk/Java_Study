package lambda.ex1;

public class M2After {

    public static void print(int num, String unit) {
        System.out.println("무게: " + num + unit);
    }

    public static void main(String[] args) {
        print(10, "KG");
        print(20, "KG");
        print(200, "g");
        print(40, "g");
    }
}
