package lambda.lambda1;

public class SAMMain {
    public static void main(String[] args) {

        SAMInterface samInterface = () -> {
            System.out.println("Hello Lambda");
        };
        samInterface.run();

//        NoSAMInterface noSAMInterface = () -> {
//            System.out.println("Hello Lambda");
//        };
//        noSAMInterface.run();
//        noSAMInterface.go();

    }
}
