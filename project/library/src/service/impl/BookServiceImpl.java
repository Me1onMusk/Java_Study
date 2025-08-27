package service.impl;

import domain.Book;
import repository.BookRepository;
import service.BookService;

import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 책 등록 //
    @Override
    public Book registerBook(String isbn, String title, String author, int totalCopies) {

        // ISBN 중복 검사
        if(bookRepository.findByIsbn(isbn).isPresent()) {
            throw new IllegalStateException("이미 존재하는 ISBN입니다: " + isbn);
        }

        Book book = new Book(isbn, title, author, totalCopies);
        bookRepository.save(book);
        return book;
    }

    // 책 리스트 //
    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    // 책 검색 //
    @Override
    public List<Book> searchBooks(String keyword) {
        // 모든 책을 가져옴
        return bookRepository.findAll().stream()
                // 제목(title) 또는 저자(author)에 키워드가 포함되어 있는지 필터링 (대소문자 무시)
                .filter(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                        book.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
                        book.getIsbn().toLowerCase().contains(keyword.toLowerCase())
                )
                // 결과를 리스트로 수집하여 반환
                .collect(Collectors.toList());
    }

    // 책 얻기 //
    @Override
    public Book getBook(long id) {
        // Repository를 통해 ID로 책을 찾고, 없으면 예외 발생
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID에 해당하는 책을 찾을 수 없습니다: " + id));
    }
}
