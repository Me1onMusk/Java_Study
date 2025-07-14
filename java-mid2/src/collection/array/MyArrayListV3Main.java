package collection.array;

public class MyArrayListV3Main {
    public static void main(String[] args) {

        MyArrayListV3 list = new MyArrayListV3();

        System.out.println("== 데이터 추가 ==");
        System.out.println(list);
        list.add("a");
        System.out.println(list);
        list.add("b");
        System.out.println(list);
        list.add("c");
        System.out.println(list);

        System.out.println("== 원하는 위치에 넣기 ==");
        list.add(3, "addList");  //O(1)
        System.out.println(list);

        list.add(0, "addFirst");  //O(n)
        System.out.println(list);

        System.out.println(("== 원하는 위치 삭제 =="));
        Object remove1 = list.remove(4);  //remove Last O(1)
        System.out.println("remove1 = " + remove1);
        System.out.println(list);

        Object remove2 = list.remove(0);  //remove First O(n)
        System.out.println("remove2 = " + remove2);
        System.out.println(list);

        System.out.println("== 기능 사용 ==");
        System.out.println("list.size() = " + list.size());
        System.out.println("list.get(1) = " + list.get(1));
        System.out.println("list.indexof(\"c\") = " + list.indexOf("c"));
        System.out.println("list.set(2, \"z\") = " + list.set(2, "z"));
        System.out.println(list);

        System.out.println("== 범위 초과 ==");
        list.add("d");
        System.out.println(list);
        list.add("e");
        System.out.println(list);

        // 범위 초과, capacity가 늘어나지 않으면 예외 발생 ArrayIndexOutOfBoundsException
        list.add("f");
        System.out.println(list);

    }
}
