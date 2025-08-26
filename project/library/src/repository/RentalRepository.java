package repository;

import domain.Rental;

import java.util.List;
import java.util.Optional;

// 렌탈 저장소 //
public interface RentalRepository {
    void save(Rental rental);
    Optional<Rental> findById(Long id);
    List<Rental> findAll();
    List<Rental> findByMemberId(Long memberId); // 내 대여목록 조회용
    void delete(Long id);
}
