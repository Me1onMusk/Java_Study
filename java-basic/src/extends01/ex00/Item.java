package extends01.ex00;

public class Item {

    // 공통 속성 //
    private String name;
    private int price;

    // 생성자 //
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void print() {
        System.out.println("이름: " + name + ", 가격: " + price);
    }
}
