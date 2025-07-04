package lang.wrapper;

public class WrapperUtilsMain {
    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(10);       //숫자, 래퍼 객체 반환 => int -> Integer
        System.out.println("i1 = " + i1);

        Integer i2 = Integer.valueOf("10");     //문자열, 래퍼 객체 반환 => String -> Integer(참조형)
        System.out.println("i2 = " + i2);

        int intValue = Integer.parseInt("10");  //문자열 전용, 기본형 반환 => String -> int(기본형)
        System.out.println("intValue = " + intValue);
        
        //비교
        int compareResult = i1.compareTo(20);  //10과 20 비교 => 오른쪽이 크면: 1 / 같으면: 0 / 오른쪽이 작으면: -1
        System.out.println("compareResult = " + compareResult);

        //산술 연산
        System.out.println("sum = " + Integer.sum(10, 20));
        System.out.println("max = " + Integer.max(10, 20));
        System.out.println("min = " + Integer.min(10, 20));
    }
}
