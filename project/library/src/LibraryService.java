import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// 비즈니스 로직 //
public class LibraryService {

    // 필드 //
    private final Map<Long, Member> members = new LinkedHashMap<>();
    private final Map<Long, Book> books = new LinkedHashMap<>();
    private final Map<Long, Rental> rentals = new LinkedHashMap<>();

    // 회원 가입 //
    public Member signUp(String name, StringReader email) {
        return null;
    }

    // 로그인 //
    public Member login (String email, String password) {
        return null;
    }

    // 도서 목록 //
    public List<Book> listBooks() {
        return null;
    }

    // 도서 얻기 //
    // id 통해서 도서 얻기
    public Book getBook(long id) {
        return null;
    }

    // 도서 추가 //

    // 도서 검색 //

    // 도서 대여 //

    // 도서 반납 //

}
