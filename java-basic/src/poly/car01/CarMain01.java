package poly.car01;

public class CarMain01 {
    public static void main(String[] args) {
        Driver driver = new Driver();

        K3Car k3Car = new K3Car();
        driver.setCar(k3Car);
        driver.drive();

        System.out.println();

        Model3Car model3Car = new Model3Car();
        driver.setCar(model3Car);
        driver.drive();

        System.out.println();

        Avente avente = new Avente();
        driver.setCar(avente);
        driver.drive();
    }
}
