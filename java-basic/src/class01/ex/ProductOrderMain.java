package class01.ex;

public class ProductOrderMain {
    public static void main(String[] args) {

        ProductOrder[] orders = {
                new ProductOrder("두부", 2000, 2),
                new ProductOrder("김치", 5000, 1),
                new ProductOrder("콜라", 1500, 2  )
        };

        for (ProductOrder order : orders) {
            order.print();
        }
        System.out.println("총 결제 금액: " + ProductOrder.totalPrice);
    }
}
