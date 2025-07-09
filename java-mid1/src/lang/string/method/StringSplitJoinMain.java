package lang.string.method;

public class StringSplitJoinMain {
    public static void main(String[] args) {

        String str = "Apple,Banana,Orange";

        // split()
        String[] arr = str.split(",");
        for (String s : arr) {
            System.out.println(s);
        }

        String joinStr1 = "";
        for (String s : arr) {
            joinStr1 += s + "-";
        }
        System.out.println(joinStr1);

        String joinStr2 = "";
        for(int i = 0; i < arr.length; i++) {
            String string = arr[i];
            joinStr2 += string;
            if (i != arr.length -1)
                joinStr2 += "-";
        }
        System.out.println(joinStr2);

        // join() - 문자
        String joinStr = String.join("-", "A", "B", "C");
        System.out.println(joinStr);

        // join() - 배열
        String joinStr3 = String.join("-", arr);
        System.out.println(joinStr3);

    }
}
