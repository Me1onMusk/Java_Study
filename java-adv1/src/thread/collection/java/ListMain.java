package thread.collection.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.util.Collections.synchronizedList;

public class ListMain {
    public static void main(String[] args) {

//        List<String> list = synchronizedList(new ArrayList<>());
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("list = " + list);

    }
}
