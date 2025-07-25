package generic.ex03;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV3 {
    public static void main(String[] args) {

        AnimalHospitalV3<Dog> dogHospital = new AnimalHospitalV3<>();
        AnimalHospitalV3<Cat> catHospital = new AnimalHospitalV3<>();
//        AnimalHospitalV3<Object> objectHospital = new AnimalHospitalV3<>();
//        AnimalHospitalV3<String> stringHospital = new AnimalHospitalV3<>();

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
        Dog biggerDog = dogHospital.bigger(new Dog("멍멍이2", 200));  //다운 캐스팅
        System.out.println("biggerDog = " + biggerDog);

    }
}
