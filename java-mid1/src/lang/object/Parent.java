package lang.object;

import java.lang.Object;

// 부모가 없으면 묵시적으로 Object 클래스를 상속받는다.
public class Parent extends Object{
    public void parentMethod() {
        System.out.println("Parent method");
    }
}
