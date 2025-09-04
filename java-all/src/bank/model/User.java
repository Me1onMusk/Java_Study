package bank.model;

// 사용자 //
// User DTO //
public class User {

    private int userID;
    private String name;
    private String id;
    private String password;
    private String email;
    private String phone;

    // 생성자 //
    public User() {  }
    public User(String name, String id, String password, String email, String phone) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
    public User(int userID, String name, String id, String password, String email, String phone) {
        this.userID = userID;
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
