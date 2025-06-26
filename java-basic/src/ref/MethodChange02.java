package ref;

public class MethodChange02 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        System.out.println("dataA의 주소: " + dataA);
        System.out.println("메서드 호출 전: dataA.value = " + dataA.value);
        changePrimitive(dataA);
        System.out.println("메서드 호출 후: dataA.value = " + dataA.value);
    }

    static void changePrimitive(Data dataX) {
        System.out.println("dataX의 주소: " + dataX);
        dataX.value = 20;
    }
}
