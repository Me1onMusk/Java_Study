package mid1.lang.string.test;

/*
    <문제10>
        split() 를 사용해서 fruits 를 분리하고, join() 을 사용해서 분리한 문자들을 하나로 합쳐라.
        실행 결과를 참고해라.
 */

public class TestString10 {
    public static void main(String[] args) {

        String fruits = "apple,banana,mango";

        //분리하기
        String[] fruit = fruits.split(",");
        for (String str : fruit) {
            System.out.println(str);
        }

        //합치기
        String joined = String.join("->", fruit);
        System.out.println("joinedString = " + joined);

    }
}
