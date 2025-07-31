package mid2.collection.array;

import java.util.Arrays;

public class MyArrayListV1 {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size = 0;

    // 생성자 //
    public MyArrayListV1() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    // 크기 지정 생성자 //
    public MyArrayListV1(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    // 크기 반환 //
    public int size() {
        return size;
    }

    // 값 추가 //
    public void add(Object e) {
        elementData[size] = e;
        size++;
    }

    // 값 얻기 //
    public Object get(int index) {
        return elementData[index];
    }

    // 값 변경 //
    public Object set(int index, Object element) {
        Object oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    // 해당값 인덱스 얻기 //
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i]))
                return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) + " size=" + size + ", capacity=" + elementData.length;
    }

}
