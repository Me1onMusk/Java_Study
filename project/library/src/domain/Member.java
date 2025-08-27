package domain;

import common.security.Passwords;

import java.util.Objects;

// 회원 클래스 //
public class Member {

    // 필드 //
    private final long id;
    private final String name;
    private final String email;
    private final String passwordHash;
    private final Role role;

    private static long sequence = 0;  // auto-increment

    // 기본 생성자 //
    public Member(long id, String name, String email, String passwordHash, Role role) {
        // 유효성 검사
        if (name == null || name.isBlank()) throw new IllegalArgumentException("이름은 필수입니다.");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("이메일은 필수입니다.");
        if (passwordHash == null || passwordHash.isBlank()) throw new IllegalArgumentException("비밀번호는 필수입니다.");

        // 필드 초기화
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = (role == null) ? Role.USER : role; // role이 null이면 기본값 USER 할당
    }

    // ID를 자동으로 발급하는 보조 생성자 //
    public Member(String name, String email, String passwordHash, Role role) {
        this(++sequence, name, email, passwordHash, role);
    }

    // 비밀번호 검증 //
    public boolean authenticate(String rawPw) {
        return Passwords.matches(rawPw, passwordHash);
    }

    // Getter 메서드 //
    public long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public Role getRole() { return role; }

    // equals() //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id &&
                Objects.equals(name, member.name) &&
                Objects.equals(email, member.email) &&
                Objects.equals(passwordHash, member.passwordHash) &&
                role == member.role;
    }

    // hashCode() //
    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, passwordHash, role);
    }

    // toString() //
    @Override
    public String toString() {
        return "domain.Member[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", role=" + role +
                ']';
    }

}
