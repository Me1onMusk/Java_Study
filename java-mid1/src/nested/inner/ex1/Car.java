package nested.inner.ex1;

public class Car {

    // 필드 //
    private String model;
    private int chargeLevel;
    private Engine engine;

    // 생성자 //
    public Car(String model, int chargeLevel) {
        this.model = model;
        this.chargeLevel = chargeLevel;
        this.engine = new Engine(this);
    }

    // Engine 에서만 사용하는 메서드
    public String getChargeLevel() {
        return chargeLevel + "%";
    }

    // Engine 에서만 사용하는 메서드
    public String getModel() {
        return model;
    }
    
    public void start() {
        engine.start();
        System.out.println(model + " 시작 완료");
    }
}
