package class01;

public class ClassStart03 {
    public static void main(String[] args) {
        Student student1;
        student1 = new Student();
        student1.name = "Kim";
        student1.age = 20;
        student1.grade = 90;

        Student student2;
        student2 = new Student();
        student2.name = "Lee";
        student2.age = 30;
        student2.grade = 80;

        System.out.println("이름: " + student1.name + " 나이: " + student1.age + " 성적: " + student1.grade);
        System.out.println("이름: " + student2.name + " 나이: " + student2.age + " 성적: " + student2.grade);
    }
}
