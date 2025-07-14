package generic.test.ex3;

import generic.test.ex3.unit.BioUnit;
import generic.test.ex3.unit.Marine;
import generic.test.ex3.unit.Zealot;

public class UnitPrinterTest {

    public static void main(String[] args) {

        Shuttle<Marine> shuttle1 = new Shuttle<>();
        shuttle1.in(new Marine("마린", 40));

        Shuttle<Zealot> shuttle2 = new Shuttle<>();
        shuttle2.in(new Zealot("질럿", 100));

        Shuttle<Zealot> shuttle3 = new Shuttle<>();
        shuttle3.in(new Zealot("질럿", 100));

        UnitPrinter.printerV1(shuttle1);
        UnitPrinter.printerV2(shuttle1);

    }

    static class Shuttle <T extends BioUnit> {
        private T unit;

        public void in(T unit) {
            this.unit = unit;
        }

        public T out() {
            return unit;
        }

    }

    static class UnitPrinter {
        static <T extends BioUnit> void printerV1(Shuttle<T> shuttle) {
            T unit = shuttle.out();
            System.out.println("이름 = " + unit.getName() + ", HP = " + unit.getHp());
        }

        // 와일드 카드 //
        static void printerV2(Shuttle<? extends BioUnit> shuttle) {
            BioUnit unit = shuttle.out();
            System.out.println("이름 = " + unit.getName() + ", HP = " + unit.getHp());
        }
    }
}
