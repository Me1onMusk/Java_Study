package lang.wrapper;

// int 래퍼 클래스 //
public class MyInteger {
    private final int value;

    // 생성자 //
    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int compareTo(int target) {
        if(this.value < target) return -1;
        else if(this.value > target) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(value);  //숫자를 문자로 변경
//        return "" + value;  //문자 + 숫자 -> 문자
    }
}
