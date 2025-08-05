package mid2.generic.ex4;

import mid2.generic.animal.Cat;
import mid2.generic.animal.Dog;

public class MethodMain2{
    public static void main(String[] args) {

        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("야옹이", 100);


        AnimalMethod.checkUp(dog);
        AnimalMethod.checkUp(cat);

    }
}
