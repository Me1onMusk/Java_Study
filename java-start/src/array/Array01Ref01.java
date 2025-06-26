package array;

public class Array01Ref01 {
    public static void main(String[] args) {
        int [] students;        //배열 변수 선언
        students = new int[5];  //배열 생성

        //변수 값 대입
        students[0] = 90;
        students[1] = 80;
        students[2] = 70;
        students[3] = 60;
        students[4] = 50;

        System.out.println(students);

        System.out.println("학생1 점수: " + students[0]);
        System.out.println("학생2 점수: " + students[1]);
        System.out.println("학생3 점수: " + students[2]);
        System.out.println("학생4 점수: " + students[3]);
        System.out.println("학생5 점수: " + students[4]);
    }
}

/*
    1. 기본형
        int(4byte), long(8byte), double(8byte), float, boolean
    2. 참조형
        배열
 */