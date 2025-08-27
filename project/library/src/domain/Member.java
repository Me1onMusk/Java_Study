package domain;

import common.security.Passwords;

import java.time.LocalDate;
import java.util.Objects;

// 회원 클래스 //
public class Member {

    // 필드 //
    private final long id;              //아이디
    private final String name;          //이름
    private final String email;         //이메일
    private final String passwordHash;  //비밀번호 (해시)
    private final Role role;            //역할 (관리자 || 사용자)
    private boolean isSuspended;        //대여 정지 확인
    LocalDate suspensionEndDate;        //연체 만기일

    private static long sequence = 0;  // auto-increment

    // 기본 생성자 //
    public Member(long id, String name, String email, String passwordHash, Role role, boolean isSuspended, LocalDate suspensionEndDate) {
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
        this.isSuspended = false;
        this.suspensionEndDate = null;
    }

    // ID를 자동으로 발급하는 보조 생성자 //
    public Member(String name, String email, String passwordHash, Role role, boolean isSuspended, LocalDate suspensionEndDate) {
        this(++sequence, name, email, passwordHash, role, isSuspended, suspensionEndDate);
    }

    // 회원 대여 정지 상태 설정 //
    public Member suspend(LocalDate endDate) {
        return new Member(id, name, email, passwordHash, role, true, endDate);
    }

    // 회원 대여 정지 상태 해지 //
    public Member clearSuspension() {
        return new Member(id, name, email, passwordHash, role, false, null);
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
    public boolean isSuspended() { return isSuspended; }
    public void setSuspended(boolean isSuspended) { this.isSuspended = isSuspended; }
    public LocalDate getSuspensionEndDate() { return suspensionEndDate; }

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
