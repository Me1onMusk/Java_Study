package enumeration.test.ex1;

public enum AuthGrade {

    GUEST (1, "손님"),
    LOGIN (2, "로그인 회원"),
    ADMIN (3, "관리자");

    // 필드 (멤버변수) //
    private final int level;
    private final String description;

    // 생성자 //
    AuthGrade(int level, String description) {
        this.level = level;
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }
}
