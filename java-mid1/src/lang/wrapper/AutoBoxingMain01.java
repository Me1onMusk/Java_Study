package lang.wrapper;

public class AutoBoxingMain01 {
    public static void main(String[] args) {
        //Primitive -> Wrapper (박싱)
        int value = 7;
        Integer boxedValue = Integer.valueOf(value);

        //Wrapper -> Primitive (언박싱)
        int unboxedValue = boxedValue.intValue();

        System.out.println("boxedValue = " + boxedValue);
        System.out.println("unboxedValue = " + unboxedValue);
    }
}
