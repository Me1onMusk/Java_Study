package static02.ex;

public class Car {

    // 필드 (인스턴스 변수)
    private final String carName;
    private static int totalCars;

    // 생성자 //
    public Car(String carName) {
        this.carName = carName;
        totalCars++;
        System.out.println("차량 구입, 이름: " + carName);
    }

    // 클래스 메서드 //
    public static void showTotalCar() {
        System.out.println("구매한 차량 수: " + totalCars);
    }
}
