package poly.basic;

public class CastingMain03 {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = (Parent) child;  //업캐스팅은 생략 가능, 생략 권장
        Parent parent1 = child;  //업캐스팅 생략

        parent.parentMethod();
        parent1.parentMethod();
    }
}
