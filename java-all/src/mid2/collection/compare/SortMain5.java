package mid2.collection.compare;

import java.util.TreeSet;

public class SortMain5 {
    public static void main(String[] args) {

        MyUser myUser1 = new MyUser("Kim", 30);
        MyUser myUser2 = new MyUser("Lee", 20);
        MyUser myUser3 = new MyUser("Park", 10);

        TreeSet<MyUser> users = new TreeSet<>();
        users.add(myUser1);
        users.add(myUser2);
        users.add(myUser3);

        System.out.println("Comparable 기본 정렬");
        System.out.println(users);

        TreeSet<MyUser> users2 = new TreeSet<>(new IdComparator());
        users2.add(myUser1);
        users2.add(myUser2);
        users2.add(myUser3);
        System.out.println("IdComparator 정렬");
        System.out.println(users2);

    }
}
