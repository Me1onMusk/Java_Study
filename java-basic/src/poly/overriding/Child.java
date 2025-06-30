package poly.overriding;

public class Child extends Parent{
    public String value = "child";

    @Override
    public void parentMethod() {
        System.out.println("child method");
    }
}
