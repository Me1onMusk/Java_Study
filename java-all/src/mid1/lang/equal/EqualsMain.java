package mid1.lang.equal;

import java.util.Objects;

public class EqualsMain {
    public static void main(String[] args) {

        Person p1 = new Person("111111", "Lee");
        // 해시코드A, 해시코드B -> 해시코드F
        Person p2 = new Person("111111", "Kim");
        // 해시코드A, 해시코드C -> 해시코드F
        Person p3 = new Person("123456", "Kim");
        // 해시코드D, 해시코드C -> 해시코드F

        if(p1.equals(p2))
            System.out.println("같은 사람입니다.");
        else
            System.out.println("다른 사람입니다.");

        if(p2.equals(p3))
            System.out.println("같은 사람입니다.");
        else
            System.out.println("다른 사람입니다.");

    }
}

class Person {
    String name;
    String ID;

    public Person(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person person) {
//            return this.name.equals(person.name) && this.ID.equals(person.ID);
            return person.hashCode() == this.hashCode();
        }
        return false;
    };

    @Override
    public int hashCode() {
        // 이름과 ID를 가지고 해시코드 만들기
        return Objects.hash(name, ID);
    }
}