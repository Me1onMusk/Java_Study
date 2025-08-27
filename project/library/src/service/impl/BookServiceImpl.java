package service.impl;

import domain.Book;
import repository.BookRepository;
import service.BookService;

import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    // 도서 저장소 주입 //
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 도서 등록 //
    @Override
    public Book registerBook(String isbn, String title, String author, int totalCopies) {
        // 1.ISBN 중복 검사
        if(bookRepository.findByIsbn(isbn).isPresent())
            throw new IllegalStateException("이미 존재하는 ISBN입니다: " + isbn);
        // 2.책 객체 생성
        Book book = new Book(isbn, title, author, totalCopies);
        // 3.책 저장
        bookRepository.save(book);
        return book;
    }

    // 모든 도서 리스트 //
    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    // 도서 검색 //
    @Override
    public List<Book> searchBooks(String keyword) {
        return bookRepository.findAll().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                        book.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
                        book.getIsbn().toLowerCase().contains(keyword.toLowerCase())
                )
                .collect(Collectors.toList());
    }

    // ID로 도서 얻기 //
    @Override
    public Book getBook(long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID에 해당하는 책을 찾을 수 없습니다: " + id));
    }
}
