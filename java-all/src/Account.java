public class Account {

    private final String accountNo;
    private final String accountName;
    private String password;
    private long balance;

    public Account(String accountNo, String accountName, String password, long balance) {
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.password = password;
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
    public void setPassword (String password) {this.password = password;}
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return String.format("%s \t %s \t %d",accountNo, accountName, balance);
    }

}
