package basic.poly.basic;

public class PolyMain {
    public static void main(String[] args) {

        //부모 변수가 부모 인스턴스 참조
        System.out.println("Parent -> Parent");
        Parent parent1 = new Parent();
        parent1.parentMethod();  // Parent.parentMethod

        //자식 변수가 자식 인스턴스 참조
        System.out.println("Child -> Child");
        Child child = new Child();
        child.childMethod();    // Child.childMethod

        //부모 변수가 자식 인스턴스 참조(다형적 참조)
        System.out.println("Parent -> Child");
        Parent parent2 = new Child();
        parent2.parentMethod();  // Parent.parentMethod

//        Child child1 = new Parent(); // 자식은 부모를 담을 수 없다.

    }
}
