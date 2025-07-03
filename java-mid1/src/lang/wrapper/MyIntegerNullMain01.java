package lang.wrapper;

public class MyIntegerNullMain01 {
    public static void main(String[] args) {
        MyInteger[] myIntegers = { new MyInteger(-1), new MyInteger(0), new MyInteger(1), new MyInteger(2), new MyInteger(3) };
        
        System.out.println(findValue(myIntegers, -1));
        System.out.println(findValue(myIntegers, 0));
        System.out.println(findValue(myIntegers, 1));
        System.out.println(findValue(myIntegers, 100));
    }

    private static MyInteger findValue (MyInteger[] myIntegers, int target) {
        for(MyInteger myInteger : myIntegers) {
            if(myInteger.getValue() == target) return myInteger;
        }
        return null;
    }
}
