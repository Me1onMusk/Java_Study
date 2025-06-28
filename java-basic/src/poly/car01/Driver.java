package poly.car01;

// 클라이언트 //
public class Driver {
    private Car car;

    public void setCar(Car car) {
        System.out.println("자동차를 설정합니다: " + car);
        this.car = car;
    }

    public void drive() {
        car.startEngine();
        car.pressAccelerator();
        car.stopEngine();
    }

}

