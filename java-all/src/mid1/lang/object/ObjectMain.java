package mid1.lang.object;

public class ObjectMain {
    public static void main(String[] args) {

        Child child = new Child();
        child.childMethod();   // Child.childMethod
        child.parentMethod();  // Parent.parentMethod

        // toString()은 Object 클래스의 메서드
        String string = child.toString();
        System.out.println(string);  // mid1.lang.object.Child@3f99bd52

    }
}
