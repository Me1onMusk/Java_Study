package poly.basic;

public class CastingMain05 {
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
        //1.new Parent() instanceof Child
        //2.new Child() instanceof Child
        //오른쪽에 있는 타입에 왼쪽에 있는 인스턴스의 타입이 들어갈수 있는가?
        if (parent instanceof Child) {
            //Child c = parent;
            System.out.println("Child 인스턴스 맞음");
            Child child = (Child) parent;
            child.childMethod();
        }
    }
}
