package lambda.lambda1;

import lambda.Procedure;

// 익명 함수 //
public class ProcedureMain1 {
    public static void main(String[] args) {
        Procedure procedure =  new Procedure() {
            @Override
            public void run() {
                System.out.println("Hello Lambda");
            }
        };

        procedure.run();
    }
}
