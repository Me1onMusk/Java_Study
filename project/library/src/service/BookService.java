package service;

import domain.Book;

import java.util.List;

public interface BookService {

    // 도서 등록 //
    Book registerBook(String isbn, String title, String author, int totalCopies);

    // 도서 목록 조회 //
    List<Book> listBooks();

    // 도서 검색 //
    List<Book> searchBooks(String keyword);

    // ID로 도서 조회 //
    Book getBook(long id);

}
