package class01.ex;

public class MovieReviewMain1 {
    public static void main(String[] args) {

        MovieReview inception = new MovieReview("인셉션", "인생은 무한 루프");
        MovieReview aboutTime = new MovieReview("어바웃 타임", "인생 시간 영화!");

        inception.print();
        aboutTime.print();

    }
}
