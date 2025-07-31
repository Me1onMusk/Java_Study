package mid2.collection.array;

import java.util.Arrays;

// 제네릭을 이용한 배열 //
public class MyArrayListV4<E> {

    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elementData;
    private int size = 0;

    // 생성자 //
    public MyArrayListV4() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    // 크기 지정 생성자 //
    public MyArrayListV4(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    // 사이즈 반환 //
    public int size() {
        return size;
    }

    // 값 추가
    // 1. 배열 사이즈가 작으면 배열 크기 늘리기
    public void add(E e) {
        if (size == elementData.length)
            grow();
        elementData[size] = e;
        size++;
    }

    // 특정 위치에 값 넣기
    // 1. 배열 사이즈가 작으면 배열 크기 늘리기
    public void add(int index, E e) {
        if (size == elementData.length)
            grow();
        shiftRightFrom(index);
        elementData[index] = e;
        size++;
    }

    //요소의 마지막부터 index까지 오른쪽으로 밀기
    private void shiftRightFrom(int index) {
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
    }

    // 인덱스 값 얻기 //
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elementData[index];
    }

    // 인덱스 값 변경하기
    public E set(int index, E element) {
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    // 인덱스 값 제거하기
    // 1. 제거하고 왼쪽으로 값 밀기
    public E remove(int index) {
        E oldValue = get(index);
        shiftLeftFrom(index);
        size--;
        elementData[size] = null;
        return oldValue;
    }

    //요소의 index부터 마지막까지 왼쪽으로 밀기
    private void shiftLeftFrom(int index) {
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
    }

    // 값의 인덱스 위치 얻기 //
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i]))
                return i;
        }
        return -1;
    }

    // 배열 크기 늘리기 //
    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;  // 2배 늘리기
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) + " size=" + size + ", capacity=" + elementData.length;
    }
}
