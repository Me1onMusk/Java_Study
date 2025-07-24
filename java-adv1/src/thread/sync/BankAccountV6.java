package thread.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV6 implements BankAccount {

    private int balance;

    private final Lock lock = new ReentrantLock();

    // 생성자 //
    public BankAccountV6(int balance) {
        this.balance = balance;
    }

    // 임계 영역 //
    @Override
    public boolean withdraw(int amount) {
        log("거래 시작 = " + getClass().getSimpleName());

        try {
            if (!lock.tryLock(500, TimeUnit.MILLISECONDS)) {  // lock이 없으면 0.5초 대기 후 false
                log("[진입 실패] 이미 처리중인 작업이 있습니다.");
                return false;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
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
        } finally {
            lock.unlock();  //ReentrantLock 이용하여 lock 해제
        }

        log("거래 종료");
        return true;
    }

    // 임계 영역 //
    @Override
    public int getBalance() {
        lock.lock();  //ReentrantLock 이용하여 lock 걸기
        try {
            return balance;
        } finally {
            lock.unlock();  //ReentrantLock 이용하여 lock 해제
        }
    }
}
