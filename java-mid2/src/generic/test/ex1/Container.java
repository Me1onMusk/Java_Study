package generic.test.ex1;

public class Container <T>{

    private T value;

    public boolean isEmpty() {
        return this.value == null;
    }

    public void setItem(T value) {
        this.value = value;
    }

    public T getItem() {
        return this.value;
    }

}
