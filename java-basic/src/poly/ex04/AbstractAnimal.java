package poly.ex04;

// 순수 추상 클래스 = 인터페이스 //
// 1.인스턴스 생성 불가
// 2.상속 시 자식은 모든 메서드를 오버라이딩
// 3.다형성을 위해 사용
public abstract class AbstractAnimal {
    public abstract void sound();
    public void move() {}
}
