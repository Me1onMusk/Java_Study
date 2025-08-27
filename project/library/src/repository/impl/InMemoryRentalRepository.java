package repository.impl;

import domain.Rental;
import repository.RentalRepository;

import java.util.*;

public class InMemoryRentalRepository implements RentalRepository {

    private final Map<Long, Rental> store = new HashMap<>();

    // 대여 저장 //
    @Override
    public void save(Rental rental) {
        store.put(rental.getId(), rental); // Rental 생성자에서 ID 자동 생성됨
    }

    @Override
    public Optional<Rental> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // 모든 대여 목록 //
    @Override
    public List<Rental> findAll() {
        return new ArrayList<>(store.values());
    }

    // 회원 ID로 대여 책 찾기 //
    @Override
    public List<Rental> findByMemberId(Long memberId) {
        List<Rental> rentals = new ArrayList<>();
        for (Rental rental : store.values()) {
            if (rental.getMemberId() == memberId)
                rentals.add(rental);
        }
        return rentals;
    }

    // 대여 삭제 //
    @Override
    public void delete(Long id) {
        store.remove(id);
    }

}
