package mid1.lang.string.method;

public class StringSplitJoinMain {
    public static void main(String[] args) {

        String str = "Apple,Banana,Orange";

        // split()
        // Apple
        // Banana
        // Orange
        String[] splitStr = str.split(",");
        for(String s : splitStr) {
            System.out.println(s);
        }

        // join()
        String joinedStr = String.join("-", "A", "B", "C");
        System.out.println("연결된 문자열: " + joinedStr);  // 연결된 문자열: A-B-C

        // 문자열 배열 연결
        String result = String.join("-", splitStr);
        System.out.println("result = " + result);  // result = Apple-Banana-Orange

    }
}
