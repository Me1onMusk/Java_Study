package thread.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV2 implements BankAccount{

    private int balance;

    // 생성자 //
    public BankAccountV2(int balance) {
        this.balance = balance;
    }

    // 임계 영역 //
    @Override
    public synchronized boolean withdraw(int amount) {
        log("거래 시작 = " + getClass().getSimpleName());

        // 임계 영역 시작 //
        //잔고 < 출금액 보다 적으면, 진행하면 안됨
        log("[검증 시작]: " + amount + "원, 잔액: " + balance + "원");
        if (balance < amount) {
            log("[검증 실패] 출금액: " + amount + "원, 잔액: " + balance + "원");
            return false;
        }

        //잔고 > 출금액보다 많으면, 진행 (정상 로직)
        log("[검증 완료]: " + amount + "원, 잔액: " + balance + "원");
        sleep(1000);  //출금에 걸리는 시간으로 설정
        balance -= amount;
        log("[출금 완료]: " + amount + "원, 잔액: " + balance + "원");
        // 임계 영역 끝 //

        log("거래 종료");
        return true;
    }

    // 임계 영역 //
    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
