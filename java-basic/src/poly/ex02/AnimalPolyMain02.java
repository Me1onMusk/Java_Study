package poly.ex02;

public class AnimalPolyMain02 {
    public static void main(String[] args) {

        Animal[] animals = { new Dog(), new Cat(), new Caw() };

        for (Animal animal : animals) {
            soundAnimal(animal);
        }

    }

    // 변하지 않는 부분 //
    private static void soundAnimal(Animal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}
