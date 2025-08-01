package mid1.enumeration.ref1;

// 할인율 계산 함수 //
public class DiscountService {
    public int discount(ClassGrade classGrade, int price) {
        return price * classGrade.getDiscountPercent() / 100;
    }
}
