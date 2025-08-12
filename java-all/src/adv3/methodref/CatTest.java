package adv3.methodref;

import java.util.Comparator;
import java.util.List;

public class CatTest {
    public static void main(String[] args) {

        List<Car> list = Car.cars.subList(0, 3);
        System.out.println(list.size());
        Car[] cars = list.toArray(new Car[3]);

        Comparator<Car> modelComparator = Comparator.comparing(c -> c.getModel());


    }
}
