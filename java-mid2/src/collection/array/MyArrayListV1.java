package collection.array;

import java.util.Arrays;

public class MyArrayListV1 {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size = 0;

    // 생성자 //
    public MyArrayListV1() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    // 원하는 크기 설정 생성자 //
    public MyArrayListV1(int capacity) {
        this.elementData = new Object[capacity];
    }

    // 사이즈 반환 //
    public int size() {
        return this.size;
    }

    // 값 추가 //
    public void add(Object element) {
        elementData[size++] = element;
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
