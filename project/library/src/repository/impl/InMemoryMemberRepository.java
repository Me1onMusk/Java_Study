package repository.impl;

import domain.Member;
import repository.MemberRepository;

import java.util.*;

public class InMemoryMemberRepository implements MemberRepository {

    private final Map<Long, Member> store = new HashMap<>();

    // 멤버 저장 //
    @Override
    public void save(Member member) {
        store.put(member.getId(), member); // Member 생성자에서 ID 자동 생성됨
    }

    // ID로 멤버 찾기 //
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // Email로 멤버 찾기 //
    @Override
    public Optional<Member> findByEmail(String email) {
        return store.values().stream()
                .filter(m -> m.getEmail().equals(email)).findFirst();
    }

    // 멤버 전체 찾기 //
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    // 멤버 삭제 //
    @Override
    public void delete(Long id) {
        store.remove(id);
    }
}
