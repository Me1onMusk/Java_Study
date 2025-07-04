package ref.ex;

import java.util.Scanner;

public class ProductOrderMain03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int orderCount = scanner.nextInt();
        scanner.nextLine();  //버퍼에 남은 개행 문자 제거

        ProductOrder[] orders = new ProductOrder[orderCount];

        for(int i = 0; i < orders.length; i++) {
            System.out.printf("%d번째 주문 정보를 입력하세요. \n", i+1);
            System.out.print("상품명: ");
            String productName = scanner.nextLine();

            System.out.print("가격: ");
            int price = scanner.nextInt();

            System.out.print("수량: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();  //버퍼에 남은 개행 문자 제거

            orders[i] = createOrder(productName, price, quantity);
        }
        
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
