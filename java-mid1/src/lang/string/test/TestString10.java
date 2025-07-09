package lang.string.test;

public class TestString10 {
    public static void main(String[] args) {

        String fruits = "apple,banaba,mango";

        String[] fruit = fruits.split(",");
        for (String f : fruit) {
            System.out.println(f);
        }

        String joinedFruit = String.join("->", fruit);
        System.out.println(joinedFruit);

    }
}
