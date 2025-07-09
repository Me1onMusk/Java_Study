package nested.test.ex1;

public class Library {

    Book[] books;  //책 배열
    private int bookCount;

    public void showBooks() {
        System.out.println("== 책 목록 출력 ==");
        for (int i = 0; i < bookCount; i++) {
            System.out.println("도서 제목: " + books[i].title + ", 저자: " + books[i].author);
        }
    }

    // 책 내부 클래스 //
    private static class Book {

        private final String title;
        private final String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }

    // 생성자 //
    public Library(int maxBook) {
        this.bookCount = 0;
        books = new Book[maxBook];  //최대 책 배열 생성
    }

    public void addBook(String title, String author) {

        // 검증 로직을 다 처리
        if(books.length <= bookCount) {
            System.out.println("도서관 저장 공간이 부족합니다");
            return;
        }

        // 정상 로직 처리
        books[bookCount++] = new Book(title, author);

    }

}
