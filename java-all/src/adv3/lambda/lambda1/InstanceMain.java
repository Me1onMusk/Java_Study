package adv3.lambda.lambda1;

import adv3.lambda.Procedure;

public class InstanceMain {
    public static void main(String[] args) {
        // 익명 클래스 //
        Procedure procedure1 = new Procedure() {
            @Override
            public void run() {
                System.out.println("hello! lambda");
            }
        };
        System.out.println("class.class = " + procedure1.getClass());
        // class.class = class adv3.lambda.lambda1.InstanceMain$1

        System.out.println("class.instance = " + procedure1);
        // class.instance = adv3.lambda.lambda1.InstanceMain$1@3f99bd52

        // 람다 //
        Procedure procedure2 = () -> System.out.println("hello! lambda");
        System.out.println("lambda.class = " + procedure2.getClass());
        // lambda.class = class adv3.lambda.lambda1.InstanceMain$$Lambda/0x0000022415003780

        System.out.println("lambda.instance = " + procedure2);
        // lambda.instance = adv3.lambda.lambda1.InstanceMain$$Lambda/0x0000022415003780@3a71f4dd
    }
}
