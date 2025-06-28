package poly.ex02;

public class AnimalPloyMain01 {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal caw = new Caw();

        Animal animal = new Animal();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(caw);

        soundAnimal(animal);
    }

    private static void soundAnimal(Animal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
        System.out.println();
    }
}
