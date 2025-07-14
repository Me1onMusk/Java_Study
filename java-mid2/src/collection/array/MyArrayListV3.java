package collection.array;

import java.util.Arrays;

public class MyArrayListV3 {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size = 0;

    // 생성자 //
    public MyArrayListV3() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    // 원하는 크기 설정 생성자 //
    public MyArrayListV3(int capacity) {
        this.elementData = new Object[capacity];
    }

    // 사이즈 반환 //
    public int size() {
        return this.size;
    }

    // 원하는 인덱스에 값 추가 //
    public void add(int index, Object element) {

        if (size == elementData.length)
            grow();

        // 데이터 이동
        shiftRightFrom(index);
        elementData[index] = element;
        size++;
    }

    // 값 추가 //
    public void add(Object element) {
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
    public Object remove(int index) {
        Object oldValue = elementData[index];

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
    public Object get(int index) {
        return elementData[index];
    }

    // 값 설정 //
    public Object set(int index, Object element) {
        Object oldValue = elementData[index];
        elementData[index] = element;  //원하는 값 넣기
        return oldValue;  //예전 값 출력
    }

    // 인덱스 찾기 //
    public int indexOf(Object element) {
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
