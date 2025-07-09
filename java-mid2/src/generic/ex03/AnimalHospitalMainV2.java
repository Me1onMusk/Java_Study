package generic.ex03;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV2 {
    public static void main(String[] args) {

        AnimalHospitalV2<Dog> dogHospital = new AnimalHospitalV2<>();
        AnimalHospitalV2<Cat> catHospital = new AnimalHospitalV2<>();
//        AnimalHospitalV2<Object> objectHospital = new AnimalHospitalV2<>();
//        AnimalHospitalV2<String> stringHospital = new AnimalHospitalV2<>();

        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("냐옹이1", 300);

        dogHospital.set(dog);
        dogHospital.checkup();

        catHospital.set(cat);
        catHospital.checkup();


        // 문제1.개 병원에 고양이 전달
//        dogHospital.set(cat);  //다른 타입 입력: 컴파일 실패 (매개변수 체크 실패)
        
        // 문제2. 개 타입 반환
        dogHospital.set(dog);
        Dog biggerDog = (Dog) dogHospital.bigger(new Dog("멍멍이2", 200));  //다운 캐스팅
        System.out.println("biggerDog = " + biggerDog);

    }
}
