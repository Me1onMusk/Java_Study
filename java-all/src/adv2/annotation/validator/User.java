package adv2.annotation.validator;

public class User {

    @NotEmpty (message = "이름이 비었습니다.")
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
