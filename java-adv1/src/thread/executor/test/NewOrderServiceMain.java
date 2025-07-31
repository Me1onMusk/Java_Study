package thread.executor.test;

import java.util.concurrent.ExecutionException;

public class NewOrderServiceMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String orderNo = "Order#1234";
        NewOrderService newOrderService = new NewOrderService();
        newOrderService.order(orderNo);

    }
}
