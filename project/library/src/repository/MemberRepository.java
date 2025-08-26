package repository;

import domain.Member;

import java.util.List;
import java.util.Optional;

// 멤버 저장소 //
public interface MemberRepository {
    void save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByEmail(String email); // 로그인 시 활용
    List<Member> findAll();
    void delete(Long id);
}
