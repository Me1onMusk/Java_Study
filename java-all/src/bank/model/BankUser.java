package bank.model;

// 사용자 //
public class BankUser {

    private int userID;
    private String userName;
    private String[] accounts;

    // 생성자 //
    public BankUser(int userID, String userName) {
        this.userID = userID;
        this.userName = userName;
        this.accounts = null;
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String[] getAccounts() {
        return accounts;
    }
    public void setAccounts(String[] accounts) {
        this.accounts = accounts;
    }

}
