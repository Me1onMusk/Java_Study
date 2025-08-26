package service.impl;

import domain.Member;
import domain.Role;
import repository.MemberRepository;
import security.Passwords;
import service.MemberService;

public class MemberServiceImpl implements MemberService {

    // 필드 //
    private final MemberRepository memberRepository; // 주입받는 저장소
    private static Member currentUser = null;

    // 생성자에서 Repository 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원 가입 //
    @Override
    public Member signUp(String name, String email, String pw, Role role) {
        // 이메일 중복 체크
        if (memberRepository.findByEmail(email).isPresent())
            throw new IllegalStateException("이미 등록된 이메일입니다.");

        // 비밀번호 해싱
        String hashed = Passwords.hash(pw);
        Member member = new Member(name, email, hashed, role);

        // 저장
        memberRepository.save(member);
        return member;
    }

    // 로그인 //
    @Override
    public Member login(String email, String pw) {
        Member member = memberRepository.findByEmail(email)
                .filter(mem -> mem.authenticate(pw))
                .orElseThrow(() -> new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다."));

        currentUser = member;
        return member;
    }

    // 현재 사용자 //
    @Override
    public Member getCurrentUser() {
        return currentUser;
    }

    // 로그아웃 //
    @Override
    public void logout() {
        currentUser = null;
    }

}
