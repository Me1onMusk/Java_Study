package domain;

import java.util.Objects;

// 책 객체 //
public class Book {

    // 필드 선언
    private final long id;
    private final String isbn;
    private final String title;
    private final String author;
    private final int totalCopies;
    private int availableCopies;
    private boolean isAvailable;

    private static long sequence = 0; // auto-increment

    // 기본 생성자 + 유효성 검사 //
    public Book(long id, String isbn, String title, String author, int totalCopies, int availableCopies, boolean isAvailable) {
        // 유효성 검사
        if (isbn == null || isbn.isBlank()) throw new IllegalArgumentException("ISBN은 필수입니다.");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("제목은 필수입니다.");
        if (author == null || author.isBlank()) throw new IllegalArgumentException("저자는 필수입니다.");
        if (totalCopies < 0) throw new IllegalArgumentException("총 권수는 0 이상이어야 합니다.");
        if (availableCopies < 0 || availableCopies > totalCopies)
            throw new IllegalArgumentException("대여 가능 권수가 유효하지 않습니다.");

        // 필드 초기화
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.isAvailable = true;
    }

    // ID를 자동으로 생성하는 보조 생성자 //
    public Book(String isbn, String title, String author, int total) {
        this(++sequence, isbn, title, author, total, total, true);
    }

    // Getter 메서드 //
    public long getId() {return id;}
    public String getIsbn() {return isbn;}
    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public int getTotalCopies() {return totalCopies;}
    public int getAvailableCopies() {return availableCopies;}
    public void setAvailable(boolean isAvailable) {this.isAvailable = isAvailable;}

    // 대여 가능한지 확인하는 함수 //
    public boolean isAvailableRent() {
        if (availableCopies > 0) {
            availableCopies--;
            return true;
        }
        return false;
    }

    // 반납 //
    public void returnBook() {
            availableCopies++;
    }

    // equals() //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                totalCopies == book.totalCopies &&
                availableCopies == book.availableCopies &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    // hashCode() //
    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, title, author, totalCopies, availableCopies);
    }

    // toString() //
    @Override
    public String toString() {
        return "domain.Book[" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", totalCopies=" + totalCopies +
                ", availableCopies=" + availableCopies +
                ']';
    }

}
