package reflection;

import java.lang.reflect.Field;

public class FieldUtil {
    public static void nullFieldToDefault(Object target) throws IllegalAccessException {

        Class<?> aClass = target.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();

        for (Field field : declaredFields) {
            field.setAccessible(true);

            // Null 아니면 정상
            if (field.get(target) != null) continue;

            // Null 이라면 변경
            if (field.getType() == String.class)
                field.set(target, "");
            else if (field.getType() == Integer.class)
                field.set(target, 0);

        }
    }
}
