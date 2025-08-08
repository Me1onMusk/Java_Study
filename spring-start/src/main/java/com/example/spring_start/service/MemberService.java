package com.example.spring_start.service;

import com.example.spring_start.domain.Member;
import com.example.spring_start.repository.MemberRepository;
import com.example.spring_start.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원 가입 //
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    // 중복 회원 검사 //
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {throw new IllegalStateException("이미 존재하는 회원입니다");});
    }

    // 전체 회원 조회 //
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 회원 찾기 (이름) //
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
