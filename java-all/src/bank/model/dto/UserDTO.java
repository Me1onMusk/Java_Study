package bank.model.dto;

public class UserDTO {

    // 필드 //
    private int uid;
    private String name;
    private String id;
    private String password;
    private String email;
    private String phone;

    // 생성자 //
    public UserDTO() {  }
    public UserDTO(String name, String id, String password, String email, String phone) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
    public UserDTO(int uid, String name, String id, String password, String email, String phone) {
        this.uid = uid;
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    // getter, setter //
    public int getUid() { return uid; }
    public void setUid(int uid) { this.uid = uid; }

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
        return "UserDTO{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
