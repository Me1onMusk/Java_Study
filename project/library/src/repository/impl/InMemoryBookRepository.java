package repository.impl;

import domain.Book;
import repository.BookRepository;

import java.util.*;

public class InMemoryBookRepository implements BookRepository {

    private final Map<Long, Book> store = new HashMap<>();

    // 저장 //
    @Override
    public void save(Book book) {
        store.put(book.getId(), book); // Book 생성 시 ID가 자동 부여되므로 그대로 사용
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // 모두 찾기 //
    @Override
    public List<Book> findAll() {
        return new ArrayList<>(store.values());
    }

    // 삭제 //
    @Override
    public void delete(Long id) {
        store.remove(id);
    }
}
