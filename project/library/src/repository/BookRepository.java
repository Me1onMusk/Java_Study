package repository;

import domain.Book;

import java.util.List;
import java.util.Optional;

// 도서 저장소 //
public interface BookRepository {
    void save(Book book);
    Optional<Book> findById(Long id);
    List<Book> findAll();
    void delete(Long id);
    Optional<Book> findByIsbn(String isbn);  //ISBN으로 책을 찾는 메서드 추가
}
