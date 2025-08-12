public class Account {

    private String accountNo;
    private String accountName;
    private long balance;

    public Account(String accountNo, String accountName, long balance) {
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }
    public long getBalance() {
        return balance;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setBalance(long balance) {this.balance = balance;}

    @Override
    public String toString() {
        return String.format("%s \t %s \t %d",accountNo, accountName, balance);
    }
}
