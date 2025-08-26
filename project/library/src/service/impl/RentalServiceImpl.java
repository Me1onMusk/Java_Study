package service.impl;

import domain.Member;
import domain.Rental;
import repository.RentalRepository;
import service.RentalService;

import java.util.List;

public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;

    public RentalServiceImpl(RentalRepository rentalRepository) {this.rentalRepository = rentalRepository;}

    @Override
    public Rental rentBook(long bookId, Member member) {
        return null;
    }

    @Override
    public Rental returnBook(long rentalId) {
        return null;
    }

    @Override
    public List<Rental> getRentalsByMember(Member member) {
        return List.of();
    }

    @Override
    public void checkOverdueAndApplySuspension(Member member) {

    }
}
