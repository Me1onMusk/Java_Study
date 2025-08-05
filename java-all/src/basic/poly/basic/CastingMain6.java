package basic.poly.basic;

public class CastingMain6 {
    public static void main(String[] args) {

        Parent parent1 = new Parent();
        Call(parent1);

        Parent parent2 = new Child();
        Call(parent2);

    }

    static void Call(Parent parent) {
        parent.parentMethod();
        //Child 인스턴스인 경우 childMethod() 실행
        if(parent instanceof Child child) {
            System.out.println("Child 인스턴스 맞음");
            child.childMethod();
        }
    }
}
