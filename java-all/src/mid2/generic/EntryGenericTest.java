package mid2.generic;

public class EntryGenericTest {
    public static void main(String[] args) {

        Entry<String, Integer> e1 = new Entry<>("홍길동", 20);
        Entry<String, String> e2 = new Entry<>("홍길동", "대한민국");
        Entry<Integer, Integer> e3 = new Entry<>(10, 20);
        Entry<Double, String> e4 = new Entry<>(3.14, "PI");

        Double d = e4.getKey();
        String s = e4.getValue();
        System.out.printf("%.2f, %s", d, s);

    }
}

class Entry<K, V> {
    private K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }

}
