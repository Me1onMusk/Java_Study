package lang.string.chaining;

public class MethodChainingMain03 {
    public static void main(String[] args) {

        ValueAdder adder = new ValueAdder();
        int result = adder.add(1).add(2).add(3).getValue();  //메서드 체이닝
        System.out.println("result = " + result);

        System.out.println("result = " + adder);

    }
}
