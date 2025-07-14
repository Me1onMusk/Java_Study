package collection.array;

import java.util.Arrays;

public class MyArrayListV4 <E> {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size = 0;

    // 생성자 //
    public MyArrayListV4() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    // 원하는 크기 설정 생성자 //
    public MyArrayListV4(int capacity) {
        this.elementData = new Object[capacity];
    }

    // 사이즈 반환 //
    public int size() {
        return this.size;
    }

    // 원하는 인덱스에 값 추가 //
    public void add(int index, E element) {

        if (size == elementData.length)
            grow();

        // 데이터 이동
        shiftRightFrom(index);
        elementData[index] = element;
        size++;
    }

    // 값 추가 //
    public void add(E element) {
        if (size == elementData.length)
            grow();

        elementData[size++] = element;
    }

    // 데이터를 오른쪽으로 밀기 //
    private void shiftRightFrom(int index) {
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
    }

    // 삭제 //
    public E remove(int index) {
        E oldValue = get(index);

        //데이터 이동
        shiftLeftFrom(index);
        size--;
        elementData[size] = null;

        return oldValue;
    }

    // 데이터를 왼쪽으로 밀기 //
    private void shiftLeftFrom(int index) {
        for(int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i+1];
        }
    }

    // 배열 크기 늘리기 //
    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;

        // 배열을 새로 만들고, 기존 배열을 새로운 배열에 복사
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    // 인덱스 값 찾기 //
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elementData[index];
    }

    // 값 설정 //
    public E set(int index, Object element) {
        E oldValue = get(index);
        elementData[index] = element;  //원하는 값 넣기
        return oldValue;  //예전 값 출력
    }

    // 인덱스 찾기 //
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elementData[i]))  //찾고 싶은 값의 인덱스 반환
                return i;
        }
        return -1;  //못 찾으면 -1 반환
    }

    // 출력 //
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) + " size = " + size + ", capacity = " + elementData.length;
    }

}
