package repository.impl;

import domain.Book;
import repository.BookRepository;

import java.util.*;

public class InMemoryBookRepository implements BookRepository {

    private final Map<Long, Book> store = new HashMap<>();

    // 도서 저장 //
    // <Long 아이디, 도서 객체>
    @Override
    public void save(Book book) {
        store.put(book.getId(), book); // Book 생성 시 ID가 자동 부여되므로 그대로 사용
    }

    // ID로 도서 찾기 //
    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // 도서 모두 가져오기 //
    @Override
    public List<Book> findAll() {
        return new ArrayList<>(store.values());
    }

    // ID로 도서 삭제 //
    @Override
    public void delete(Long id) {
        store.remove(id);
    }

    // ISBN 찾기 //
    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return store.values().stream()
                .filter(book -> book.getIsbn().equalsIgnoreCase(isbn))
                .findFirst();
    }

}
