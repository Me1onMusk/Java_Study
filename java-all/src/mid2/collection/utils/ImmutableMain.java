package mid2.collection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableMain {
    public static void main(String[] args) {

        // 불변 리스트 생성 //
        List<Integer> list = List.of(1, 2, 3);

        // 가변 리스트 //
        ArrayList<Integer> mutableList = new ArrayList<>(list);
        mutableList.add(4);
        System.out.println("mutableList = " + mutableList);               // mutableList = [1, 2, 3, 4]
        System.out.println("mutable class = " + mutableList.getClass());  // mutable class = class java.util.ArrayList

        // 불변 리스트 //
        // 가변 리스트 -> 불변 리스트
        List<Integer> unmodifiableList = Collections.unmodifiableList(mutableList);
        System.out.println("unmodifiableList class = " + unmodifiableList.getClass());  // unmodifiableList class = class java.util.Collections$UnmodifiableRandomAccessList

//        unmodifiableList.add(5);  //예외 발생 java.lang.UnsupportedOperationException

    }
}
