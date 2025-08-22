package mid2.collection.link;

public class MyLinkedListV1Main {
    public static void main(String[] args) {

        MyLinkedListV1 list = new MyLinkedListV1();

        System.out.println("==데이터 추가==");
        System.out.println(list);
        list.add("a");
        System.out.println(list);
        list.add("b");
        System.out.println(list);
        list.add("c");
        System.out.println(list);

        System.out.println("==기능 사용==");

        System.out.println("==범위 초과==");

    }
}
