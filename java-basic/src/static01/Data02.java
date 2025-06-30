package static01;

public class Data02 {
    public String name;  //변수 선언

    // 생성자 //
    public Data02(String name, Counter counter) {
        this.name = name;
        counter.count++;
    }
}
