package class01.ex;

public class MovieReviewMain2 {
    public static void main(String[] args) {

        MovieReview[] reviews = {
                new MovieReview("인셉션", "인생은 무한 루프"),
                new MovieReview("어바웃 타임", "인생 시간 영화!")
        };

        for (MovieReview review : reviews) {
            review.print();
        }

    }
}
