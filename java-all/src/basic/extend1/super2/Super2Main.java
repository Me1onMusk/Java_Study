package basic.extend1.super2;

public class Super2Main {
    public static void main(String[] args) {

        ClassC classC = new ClassC();
        // ClassA 생성자
        // ClassB 생성자 a=10 b=20
        // ClassC 생성자

        ClassB classB = new ClassB(10);
        // ClassA 생성자
        // ClassB 생성자 a=10 b=10
        // ClassB 생성자 a=10
    }
}
