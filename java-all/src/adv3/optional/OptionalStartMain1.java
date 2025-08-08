package adv3.optional;

import java.util.HashMap;

public class OptionalStartMain1 {

    private static final HashMap<Long, String> map = new HashMap<>();

    static {
        map.put(1L, "Kim");
        map.put(2L, "Lee");
        map.put(3L, "Park");
    }

    public static void main(String[] args) {

        findAndPrint(1L);  // 값이 있는 경우
        findAndPrint(4L);  // 값이 없는 경우

    }

    static void findAndPrint(Long id) {
        String name = findNameByID(id);

        // java.lang.NullPointerException 발생
//        System.out.println("name = " + name.toUpperCase());

        // 2. if 문을 활용한 null 체크 필요
        if(name != null)
            System.out.println(id + " : " + name.toUpperCase());
        else
            System.out.println(id + " : " + "Not Found");
    }

    static String findNameByID(Long id) {
        return map.get(id);
    }

}
