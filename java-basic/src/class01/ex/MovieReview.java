package class01.ex;

public class MovieReview {
    private String title;
    private String review;

    // 생성자 //
    public MovieReview(String title, String review) {
        this.title = title;
        this.review = review;
    }

    public void print() {
        System.out.println("영화 제목: " + title + ", 리뷰: " + review);
    };
}
