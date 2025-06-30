package poly.ex03;

public class AbstractMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        dog.sound();
        dog.move();

        soundAnimal(cat);
        soundAnimal(caw);
    }

    private static void soundAnimal(AbstractAnimal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
        animal.move();
        System.out.println();
    }
}
