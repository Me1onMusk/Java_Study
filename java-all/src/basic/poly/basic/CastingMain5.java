package basic.poly.basic;

// Instanceof
// 다운 캐스팅
public class CastingMain5 {
    public static void main(String[] args) {

     Parent parent1 = new Parent();
     Call(parent1);

     Parent parent2 = new Child();
    Call(parent2);

    }

    private static void Call (Parent parent) {
        parent.parentMethod();
        if (parent instanceof Child) {  // Child의 인스턴스라면 Child로 다운 캐스팅 가능
            System.out.println("Child 인스턴스 맞음");
            Child child = (Child) parent;
            child.childMethod();
        }
    }
}
