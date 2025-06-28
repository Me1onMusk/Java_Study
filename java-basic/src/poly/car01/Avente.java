package poly.car01;

public class Avente implements Car{
    @Override
    public void startEngine() {
        System.out.println("아반떼자동차 엔진 켜기");
    }

    @Override
    public void stopEngine() {
        System.out.println("아반떼자동차 엔진 끄기");
    }

    @Override
    public void pressAccelerator() {
        System.out.println("아반떼자동차 악셀 밟기");
    }
}
