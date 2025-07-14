package collection.array;

public class MyArrayListV2BadMain {
    public static void main(String[] args) {

        MyArrayListV3 numberList = new MyArrayListV3();

        // 숫자만 입력하기를 기대
        numberList.add(1);
        numberList.add(2);
        numberList.add("문자3");  //문자 입력
        System.out.println(numberList);

        //Object를 반환하므로 다운 캐스팅 필요
        Integer num1 = (Integer) numberList.get(0);
        Integer num2 = (Integer) numberList.get(1);

        //ClassCastException
        Integer num3 = (Integer) numberList.get(2);

    }
}
