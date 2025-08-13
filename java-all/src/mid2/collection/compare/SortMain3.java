package mid2.collection.compare;

import java.util.Arrays;

public class SortMain3 {
    public static void main(String[] args) {

        MyUser myUser1 = new MyUser("Kim", 30);
        MyUser myUser2 = new MyUser("Lee", 20);
        MyUser myUser3 = new MyUser("Park", 10);

        MyUser[] users = {myUser1, myUser2, myUser3};
        System.out.println("기본 데이터");
        System.out.println(Arrays.toString(users));

        System.out.println("Comparable 기본 정렬");
        Arrays.sort(users);
        System.out.println(Arrays.toString(users));

        System.out.println("IdComparator 정렬");
        Arrays.sort(users, new IdComparator());
        System.out.println(Arrays.toString(users));

        System.out.println("IdComparator().reversed() 정렬");
        Arrays.sort(users, new IdComparator().reversed());
        System.out.println(Arrays.toString(users));

    }
}
