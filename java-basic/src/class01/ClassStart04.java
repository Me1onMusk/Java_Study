package class01;

public class ClassStart04 {
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

        Student[] students = new Student[2];
        students[0] = student1;
        students[1] = student2;

        System.out.println("이름: " + students[0].name + " 나이: " + students[0].age + " 성적: " + students[0].grade);
        System.out.println("이름: " + students[1].name + " 나이: " + students[1].age + " 성적: " + students[1].grade);
    }
}
