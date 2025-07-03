package enumeration.ex02;

public class ClassGrade {
    public static final ClassGrade BASIC = new ClassGrade();     //0x11
    public static final ClassGrade GOLD = new ClassGrade();      //0x12
    public static final ClassGrade DIAMOND = new ClassGrade();   //0x13

    //private 생성자
    private ClassGrade() {}
}
