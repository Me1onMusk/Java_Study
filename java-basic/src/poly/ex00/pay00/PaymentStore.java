package poly.ex00.pay00;

public abstract class PaymentStore {
    public static Payment findOption(String option) {
        if (option.equals("kakao"))
            return new KakaoPay();
        else if (option.equals("naver"))
            return new NaverPay();
        else if (option.equals("toss"))
            return new TossPay();
        else
            return new DefaultPay();
    }
}
