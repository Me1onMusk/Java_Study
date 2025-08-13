package mid2.collection.compare;

import java.util.LinkedList;
import java.util.List;

public class SortMain4 {
    public static void main(String[] args) {

        MyUser myUser1 = new MyUser("Kim", 30);
        MyUser myUser2 = new MyUser("Lee", 20);
        MyUser myUser3 = new MyUser("Park", 10);

        List<MyUser> users = new LinkedList<>();
        users.add(myUser1);
        users.add(myUser2);
        users.add(myUser3);

        System.out.println("기본 데이터");
        System.out.println(users);

        System.out.println("Comparable 기본 정렬");
        users.sort(null);
        System.out.println(users);

        System.out.println("IdComparator 정렬");
        users.sort(new IdComparator());
        System.out.println(users);

    }
}
