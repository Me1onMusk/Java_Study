package lang.string.builder;

public class LoopStringMain {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        String result = "";
        for (int i=0; i<100000; i++) {
            result += "Hello World";
//            result = new StringBuilder().append(result).append("Hello Java").toString();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("result = " + result);
        System.out.println("time = " + (endTime - startTime) + " ms");

    }
}
