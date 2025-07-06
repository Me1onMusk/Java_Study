package enumeration.ref1;

// 등급별 할인률 구하기 //
public class DiscountService {
    public int discount(ClassGrade classGrade, int price) {

        return price * classGrade.getDiscountPercent() / 100;

    }
}
