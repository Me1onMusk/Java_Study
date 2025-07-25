package ref.ex;

public class ProductOrderMain02 {
    public static void main(String[] args) {

        ProductOrder[] orders = {
                createOrder("두부", 2000, 2),
                createOrder("김치", 5000, 1),
                createOrder("콜라", 1500, 2)
        };

        printOrders(orders);

        System.out.println("총 합계: " + getTotalAmount(orders) + "원");
    }

    static ProductOrder createOrder(String productName, int price, int quantity) {
        ProductOrder order = new ProductOrder();

        order.productName = productName;
        order.price = price;
        order.quantity = quantity;

        return order;
    }

    static void printOrders(ProductOrder[] orders) {
        for (ProductOrder order : orders) {
            System.out.println("상품명: " + order.productName + ", 가격: " + order.price + "원, 수량: " + order.quantity + "개 ");
        }
    }

    static int getTotalAmount(ProductOrder[] orders) {
        int totalAmount = 0;
        for (ProductOrder order : orders) {
            totalAmount += order.price * order.quantity;
        }

        return totalAmount;
    }
}
