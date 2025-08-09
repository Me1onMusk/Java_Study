package adv3.lambda.lambda1;

import adv3.lambda.MyFunction;

public class MyFunctionMain2 {
    public static void main(String[] args) {
        MyFunction myFunction = (a,b) -> a + b;
        int result = myFunction.apply(1, 2);
        System.out.println("result = " + result);
    }
}
