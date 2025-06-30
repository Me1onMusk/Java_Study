package static01;

public class Data03 {
    public String name;        //변수 선언
    public static int count;  //static 변수 선언

    // 생성자 //
    public Data03(String name) {
        this.name = name;
        count++;
    }
}
