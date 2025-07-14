package generic.test.ex3;

import generic.test.ex3.unit.BioUnit;
import generic.test.ex3.unit.Marine;
import generic.test.ex3.unit.Zealot;

public class ShuttleTest {
    public static void main(String[] args) {

        Shuttle<Marine> shuttle1 = new Shuttle<>();
        shuttle1.in(new Marine("마린", 40));
        shuttle1.showInfo();

        Shuttle<Zealot> shuttle2 = new Shuttle<>();
        shuttle2.in(new Zealot("질럿", 100));
        shuttle2.showInfo();

        Shuttle<Zealot> shuttle3 = new Shuttle<>();
        shuttle3.in(new Zealot("질럿", 100));
        shuttle3.showInfo();

    }

    static class Shuttle <T extends BioUnit> {
        private T unit;

        public void in(T unit) {
            this.unit = unit;
        }

        public void showInfo() {
            System.out.println("이름 = " + unit.getName() + ", HP = " + unit.getHp());
        }
    }
}
