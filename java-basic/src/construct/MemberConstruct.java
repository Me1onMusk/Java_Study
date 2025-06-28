package construct;

public class MemberConstruct {
    String name;
    int age;
    int grade;

    // 생성자 //
    MemberConstruct(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;

        System.out.println("생성자 호출 name: " + name + " age: " + age + " grade: " + grade);
    }

}
