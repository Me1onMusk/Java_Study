package class01.ex;

public class ProductOrder {

    private String productName;
    private int price;
    private int quantity;
    static int totalPrice;

    public ProductOrder(String productName, int price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        totalPrice += price * quantity;
    }

    public void print() {
        System.out.println("상품명: " + productName + ", 가격: " + price + ", 수량: " + quantity);
    }

}
