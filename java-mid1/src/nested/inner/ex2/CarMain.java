package nested.inner.ex2;

public class CarMain {
    public static void main(String[] args) {

        Car myCar = new Car("Model Y", 100);
        myCar.start();

    }
}

/*
    중첩 클래스 사용?
        특정 클래스(Car)가 다른 하나의 클래스 안에서(Engine)만 사용되거나, 아주 긴밀하게 연결되어 있는 특별한 경우에 사용.
 */