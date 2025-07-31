package mid2.collection.list;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elementData;
    private int size = 0;

    // 배열 생성자 //
    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    // 원하는 크기의 배열 생성 //
    public MyArrayList(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    // 사이즈 //
    @Override
    public int size() {
        return size;
    }

    // 값 추가하기 //
    @Override
    public void add(E e) {
        // 배열이 모두 차면 배열 크기 증가
        if (size == elementData.length)
            grow();
        elementData[size++] = e;
    }

    // 배열 사이즈 늘르기 //
    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;
        elementData = Arrays.copyOf(elementData, newCapacity);  // 기존 배열 복사해서 새 배열에 넣기
    }

    // 특정 인텍스에 값 넣기 //
    @Override
    public void add(int index, E e) {
        if (size == elementData.length)
            grow();
        shiftRightFrom(index);
        elementData[index] = e;
        size++;
    }

    // 요소의 마지막부터 index까지 오른쪽으로 밀기
    private void shiftRightFrom(int index) {
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
    }

    // 요소 얻기 //
    @Override
    public E get(int index) {
        return (E)elementData[index];
    }

    // 특정 index 요소 변경 //
    @Override
    public E set(int index, E e) {
        E oldValue = get(index);
        elementData[index] = e;
        return oldValue;
    }

    // 특정 index 요소 제거 //
    @Override
    public E remove(int index) {
        E oldValue = get(index);
        shiftLeftFrom(index);

        size--;
        elementData[size] = null;

        return oldValue;
    }

    // 요소의 index부터 마지막까지 왼쪽으로 밀기 //
    private void shiftLeftFrom(int index) {
        for(int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
    }

    // 특정 값의 인덱스 찾기
    // 없으면 -1
    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if(e.equals(elementData[i]))
                return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) + " size=" + size + ", capacity=" + elementData.length;
    }
}
