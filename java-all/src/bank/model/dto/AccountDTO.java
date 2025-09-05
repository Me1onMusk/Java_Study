package bank.model.dto;

public class AccountDTO {

    // 필드 //
    private int accountId;
    private int uid;
    private String accountNo;
    private int password;
    private long balance;
    private String createdAt;

    // 생성자 //
    public AccountDTO() { }
    public AccountDTO(int uid, String accountNo, int password) {
        this.uid = uid;
        this.accountNo = accountNo;
        this.password = password;
        this.balance = 0;
    }

    // getter, setter //
    public int getUid() { return uid; }
    public void setUid(int uid) { this.uid = uid; }

    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }

    public String getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(String accountNo) {this.accountNo = accountNo;}

    public long getBalance() {
        return balance;
    }
    public void setBalance(long balance) {this.balance = balance;}

    public int getPassword() {
        return password;
    }
    public void setPassword (int password) {this.password = password;}

    public String getCreatedAt() {return createdAt;}
    public void setCreatedAt(String createdAt) {this.createdAt = createdAt;}


}
