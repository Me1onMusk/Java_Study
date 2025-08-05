package mid2.generic.ex5;

import mid2.generic.animal.Animal;

public class WildcardEx {

    // 반환 타입 : void
    static <T> void printGenericV1 (Box<T> box) {
        System.out.println("T = " + box.get());
    }

    static void printWildcardV1 (Box<?> box) {
        System.out.println("? = " + box.get());
    }

    // 반환 타입 : void
    static <T extends Animal> void printGenericV2(Box<T> box) {
        T t = box.get();
        System.out.println("이름 = " + t.getName());
    }

    // 와일드 카드
    static void printWildcardV2(Box<? extends Animal> box) {
        Animal animal = box.get();
        System.out.println("이름 = " + animal.getName());
    }

    // 반환 타입 : Animal 자식 T
    static <T extends Animal> T printAndResultGeneric (Box<T> box) {
        T t = box.get();
        System.out.println("이름 = " + t.getName());
        return t;
    }

    // 제네릭 메서드 //
    // 반환 타입 : Animal
    static Animal printAndReturnWildcard(Box<? extends Animal> box) {
        Animal animal = box.get();
        System.out.println("이름 = " + animal.getName());
        return animal;
    }

}
