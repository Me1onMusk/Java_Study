package service;

import domain.Member;
import domain.Rental;

import java.util.List;

public interface RentalService {

    // 도서 대여 //
    Rental rentBook(long bookId, Member member);

    // 도서 반납 //
    Rental returnBook(long rentalId);

    // 회원 대여 이력 조회 //
    List<Rental> getRentalsByMember(Member member);

    // 연체 여부 검사 및 제재 처리 //
    void checkOverdueAndApplySuspension(Member member);

}
