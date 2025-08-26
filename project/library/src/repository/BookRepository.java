package repository;

import domain.Book;

import java.util.List;
import java.util.Optional;

// 책 저장소 //
public interface BookRepository {
    void save(Book book);
    Optional<Book> findById(Long id);
    List<Book> findAll();
    void delete(Long id);
}
