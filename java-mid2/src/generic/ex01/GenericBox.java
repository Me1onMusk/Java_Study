package generic.ex01;

// 제네릭 클래스 //
public class GenericBox<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return this.value;
    }
}
