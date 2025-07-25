package lambda.lambda6;

public class OuterMain {

    private String message = "외부 클래스";

    public void execute() {
        // 1. 익명 클래스 예시
        Runnable anonymous = new Runnable() {
            private String message = "익명 클래스";

            @Override
            public void run() {
                // 익명 클래스에서의 this는 익명 클래스의 인스턴스를 가리킴
                System.out.println("[익명 클래스] this: " + this);  //lambda.lambda6.OuterMain$1@4f023edb
                System.out.println("[익명 클래스] this.class: " + this.getClass());  //class lambda.lambda6.OuterMain$1
                System.out.println("[익명 클래스] this.message: " + this.message);  //익명 클래스
            }
        };

        // 2. 람다 예시
        Runnable lambda = () -> {
            // 람다에서의 this는 람다가 선언된 클래스의 인스턴스(즉, 외부 클래스) 가리킴
            System.out.println("[람다] this: " + this);  //lambda.lambda6.OuterMain@f6f4d33
            System.out.println("[람다] this.class: " + this.getClass());  //class lambda.lambda6.OuterMain
            System.out.println("[람다] this.message: " + this.message);  //외부 클래스
        };
        anonymous.run();
        System.out.println("----------------------------------");
        lambda.run();
    }

    public static void main(String[] args) {
            OuterMain outer = new OuterMain();
            System.out.println("[외부 클래스]: " + outer);  //lambda.lambda6.OuterMain@f6f4d33
            System.out.println("----------------------------------");
            outer.execute();
    }
}
