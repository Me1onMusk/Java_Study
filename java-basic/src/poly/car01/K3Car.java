package poly.car01;

public class K3Car implements Car{
    @Override
    public void startEngine() {
        System.out.println("기아 K3자동차 엔진 켜기");
    }
    @Override
    public void stopEngine() {
        System.out.println("기아 K3자동차 엔진 끄기");
    }
    @Override
    public void pressAccelerator() {
        System.out.println("기아 K3자동차 악셀 밟기");
    }
}
