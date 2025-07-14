package generic.test.ex3.unit;

public class BioUnit {

    // 필드 (멤버변수) //
    private String name;
    private int hp;

    // 생성자 //
    public BioUnit(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() { return this.name; }
    public int getHp() { return this.hp; }

    @Override
    public String toString() {
        return "BioUnit{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                '}';
    }
}
