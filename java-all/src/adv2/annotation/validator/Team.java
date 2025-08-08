package adv2.annotation.validator;

public class Team {

    @NotEmpty (message = "이름이 비었습니다.")
    private String name;
    private int memberCount;

    public Team(String name, int memberCount) {
        this.name = name;
        this.memberCount = memberCount;
    }

    public String getName() {
        return name;
    }
    public int getMemberCount() {
        return memberCount;
    }

}
