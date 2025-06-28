package poly.basic;

public class CastingMain01 {
    public static void main(String[] args) {
        //부모 변수가 자식 인스턴스 참조
        Parent poly = new Child();

        //다운 캐스팅 (부모 타입 -> 자식 타입)
//        poly.childMethod();
        Child child = (Child)poly;
        child.childMethod();
    }
}
