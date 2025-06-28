package poly.ex00.pay00;

public class DefaultPay implements Payment {
    @Override
    public boolean pay(int amount) {
        System.out.println("결제 수단이 없습니다.");
        return false;
    }
}
