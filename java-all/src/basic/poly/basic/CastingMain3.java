package basic.poly.basic;

// 업 캐스팅 //
public class CastingMain3 {
    public static void main(String[] args) {

        Child child = new Child();
        Parent parent = (Parent) child; //업캐스팅은 생략 가능, 생략 권장

        parent.parentMethod();

    }
}
