package mid2.collection.arrayList;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");

        list.forEach(s -> System.out.println(s));
        list.removeIf(s -> s.startsWith("b"));
        list.forEach(System.out::println);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(-1);
        list2.add(-2);

        list2.removeIf(i -> i <0);
        list2.forEach(i -> System.out.println(i));

        ArrayList<Triangle> list3 = new ArrayList<>();
        list3.add(new Triangle(5,5));
        list3.add(new Triangle(8,8));
        list3.add(new Triangle(9,9));

        list3.removeIf(t -> t.getArea() < 20);
        list3.forEach(System.out::println);

    }
}

class Triangle{
    int height;
    int base;

    public Triangle(int height, int base) {
        this.height = height;
        this.base = base;
    }

    public int getArea() {
        return height * base / 2;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "height=" + height +
                ", base=" + base +
                '}';
    }
}