package adv3.methodref;

import java.util.function.Function;

public class MethodRefEx3 {
    public static void main(String[] args) {

        // 4. 임의 객체의 인스턴스 메서드 참조(특정 타입의)
        Person person1 = new Person("Kim");
        Person person2 = new Person("Park");
        Person person3 = new Person("Lee");

        // 람다
        Function<Person, String> func1 = p -> p.introduce();
        System.out.println("person1.introduce = " + func1.apply(person1));
        System.out.println("person2.introduce = " + func1.apply(person2));
        System.out.println("person3.introduce = " + func1.apply(person3));

        // 메서드 참조
        Function<Person, String> func2 = Person::introduce;
        System.out.println("person1.introduce = " + func2.apply(person1));
        System.out.println("person2.introduce = " + func2.apply(person2));
        System.out.println("person3.introduce = " + func2.apply(person3));

    }
}
