package mid2.generic.ex4;

import mid2.generic.animal.Animal;

public class AnimalMethod {

    // 제네릭 메서드 //
    // 입력 타입 : Animal 자식 T
    // 반환 타입 : void
    public static <T extends Animal> void checkUp(T t) {
        System.out.println("동물 이름: " + t.getName());
        System.out.println("동물 크기: " + t.getSize());
        t.sound();
    }

    // 제네릭 메서드 //
    // 입력 타입 : Animal 자식 T
    // 반환 타입 : Animal 자식 T
    public static <T extends Animal> T getBigger (T t1, T t2) {
        return t1.getSize() > t2.getSize() ? t1 : t2;
    }

}
