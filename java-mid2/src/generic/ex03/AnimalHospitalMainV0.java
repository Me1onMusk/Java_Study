package generic.ex03;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV0 {
    public static void main(String[] args) {

        DogHospital dogHospital = new DogHospital();
        CatHospital catHospital = new CatHospital();

        dogHospital.set(new Dog("멍멍이1", 100));
        dogHospital.checkup();

        catHospital.set(new Cat("냐옹이1", 300));
        catHospital.checkup();


        // 문제1.개 병원에 고양이 전달
//        dogHospital.set(new Cat("냐옹이2", 5000));  //다른 타입 입력: 컴파일 오류
        
        // 문제2. 개 타입 반환
        Dog biggerDog = dogHospital.bigger(new Dog("멍멍이2", 200));
        System.out.println("biggerDog = " + biggerDog);

    }
}
