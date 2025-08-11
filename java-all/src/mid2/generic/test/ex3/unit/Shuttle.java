package mid2.generic.test.ex3.unit;

public class Shuttle<T extends BioUnit> {

    T t;

    public void in(T t) {
        this.t = t;
    }

    public T out() {
        return t;
    }

    public void showInfo() {
        System.out.println("이름: " + t.getName() + ", HP: " + t.getHp());
    }
}
