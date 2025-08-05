package mid2.generic.ex4;

import mid2.generic.animal.Animal;
import mid2.generic.animal.Cat;
import mid2.generic.animal.Dog;

public class MethodMain3 {
    public static void main(String[] args) {

        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("야옹이", 50);

        ComplexBox<Dog> hospital = new ComplexBox<>();
        hospital.set(dog);

        Cat returnCat = hospital.printAndReturn(cat);  // 제네릭 타입보다 제네릭 메서드가 높은 우선순위를 가진다.
        System.out.println("returnCat = " + returnCat);

    }
}
