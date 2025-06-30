package poly.basic;

public class CastingMain06 {
    public static void main(String[] args) {
        Parent parent1 = new Parent();
        System.out.println("parent1 호출");
        call(parent1);

        Parent parent2 = new Child();  //parent2 Parent변수에 Child 인스턴스 생성
        System.out.println("parent2 호출");
        call(parent2);
    }

    private static void call (Parent parent) {
        parent.parentMethod();
        //Child 인스턴스의 경우 childMethod() 실행
        if (parent instanceof Child child) {
            System.out.println("Child 인스턴스 맞음");
            child.childMethod();
        }
    }
}
