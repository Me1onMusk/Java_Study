package service;

import domain.Member;
import domain.Role;

// 멤버 관련 인터페이스 //
public interface MemberService {

    // 회원 가입 //
    Member signUp(String name, String email, String pw, Role role);

    // 로그인 //
    Member login (String email, String pw);

    // 현재 로그인된 사용자 반환 //
    Member getCurrentUser();

    // 로그아웃 //
    void logout();

}
