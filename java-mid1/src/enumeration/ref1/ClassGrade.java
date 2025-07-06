package enumeration.ref1;

// 클래스별 등급 //
public class ClassGrade {
    public static final ClassGrade BASIC = new ClassGrade(10);     //0x11
    public static final ClassGrade GOLD = new ClassGrade(20);      //0x12
    public static final ClassGrade DIAMOND = new ClassGrade(30);   //0x13

    private final int discountPercent;

    // private 생성자 //
    private ClassGrade(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    // 할인률 조회 //
    public int getDiscountPercent() {
        return discountPercent;
    }
}
