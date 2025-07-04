package class01;

public class ClassStart05 {
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

        Student[] students = { student1, student2 };

        for (Student student : students) {
            System.out.println("이름: " + student.name + " 나이: " + student.age + " 성적: " + student.grade);
        }
    }
}
