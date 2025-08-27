package domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

// 대여 //
public class Rental {

    // 필드 //
    private final long id;
    private final long bookId;
    private final long memberId;
    private final LocalDate rentedAt;         //대여일
    private final LocalDate dueAt;            //기간
    private final LocalDate returnedAt;       //반납일
    private final RentalStatus status;        //상태

    private static long sequence = 0;

    // 기본 생성자 //
    public Rental(long id, long bookId, long memberId, LocalDate rentedAt, LocalDate dueAt, LocalDate returnedAt, RentalStatus status) {
        // 유효성 검사
        if (bookId <= 0) throw new IllegalArgumentException("bookId는 필수입니다.");
        if (memberId <= 0) throw new IllegalArgumentException("memberId는 필수입니다.");

        // 필드 초기화 (기본값 할당 포함)
        this.id = id;
        this.bookId = bookId;
        this.memberId = memberId;
        this.rentedAt = (rentedAt == null) ? LocalDate.now() : rentedAt;
        this.dueAt = (dueAt == null) ? this.rentedAt.plusDays(14) : dueAt;
        this.returnedAt = returnedAt;
        this.status = (status == null) ? RentalStatus.RENTED : status;
    }

    // 보조 생성자 //
    public Rental(long bookId, long memberId) {
        this(++sequence, bookId, memberId, LocalDate.now(), LocalDate.now().plusDays(14), null, RentalStatus.RENTED);
    }

    // Getter 메서드 //
    public long getId() { return id; }
    public long getBookId() { return bookId; }
    public long getMemberId() { return memberId; }
    public LocalDate getRentedAt() { return rentedAt; }      //대여일
    public LocalDate getDueAt() { return dueAt; }            //기간
    public LocalDate getReturnedAt() { return returnedAt; }  //반납일
    public RentalStatus getStatus() { return status; }       //상태

    // 반납 //
    public Rental markReturned(LocalDate date) {
        if (status == RentalStatus.RETURNED)
            throw new IllegalStateException("이미 반납된 대여입니다.");
        LocalDate returnDate = (date == null) ? LocalDate.now() : date;
        return new Rental(id, bookId, memberId, rentedAt, dueAt, returnDate, RentalStatus.RETURNED);
    }

    // 대여 및 연체인지 확인 //
    /*
        대여 상태가 아님 -> false
        대여 상태 && 연체 -> true
        대여 상태 && 연체X -> false
     */
    public boolean isOverdue() {
        return status == RentalStatus.RENTED && dueAt.isBefore(LocalDate.now());
    }

    // 연체일 계산 //
    /*
        대여 상태가 아님 -> 0
        대여 상태 && 연체X -> 0
        대여 상태 && 연체 -> 연체일 계산 

     */
    public long overdueDays() {
        return isOverdue() ? ChronoUnit.DAYS.between(dueAt, LocalDate.now()) : 0;
    }

    // equals() //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return id == rental.id &&
                bookId == rental.bookId &&
                memberId == rental.memberId &&
                Objects.equals(rentedAt, rental.rentedAt) &&
                Objects.equals(dueAt, rental.dueAt) &&
                Objects.equals(returnedAt, rental.returnedAt) &&
                status == rental.status;
    }

    // hashCode() //
    @Override
    public int hashCode() {
        return Objects.hash(id, bookId, memberId, rentedAt, dueAt, returnedAt, status);
    }

    // toString() //
    @Override
    public String toString() {
        return "domain.Rental[" +
                "id=" + id +
                ", bookId=" + bookId +
                ", memberId=" + memberId +
                ", rentedAt=" + rentedAt +
                ", dueAt=" + dueAt +
                ", returnedAt=" + returnedAt +
                ", status=" + status +
                ']';
    }

}
