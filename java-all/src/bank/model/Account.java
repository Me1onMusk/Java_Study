package bank.model;

// 계좌 객체 //
public class Account {

    private int userID;
    private final String accountNo;
    private String password;
    private long balance;

    // 계좌 정보 //
    public Account(String accountNo, String password, long balance) {
        this.accountNo = accountNo;
        this.password = password;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public long getBalance() {
        return balance;
    }
    public void setBalance(long balance) {this.balance = balance;}

    public String getPassword() {
        return password;
    }
    public void setPassword (String password) {this.password = password;}

}
