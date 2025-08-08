package adv3.optional;

import java.util.HashMap;
import java.util.Optional;

public class OptionalStartMain2 {
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
        Optional<String> optName = findNameByID(id);
        String name = optName.orElse("Not Found");  // 값이 null 이면 Not Found
        System.out.println(id + " : " + name.toUpperCase());
    }

    static Optional<String> findNameByID(Long id) {
        String findName = map.get(id);
        Optional<String> optName = Optional.ofNullable(findName);  // null이 될수 있음.
        return optName;
    }
}
