package annotation.validator;

import java.lang.reflect.Field;

public class Validator {

    public static void validate(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();  //객체 모든 필드 가져오기

        for (Field field : fields) {
            field.setAccessible(true);

            // @NotEmpty 어노테이션 검사 //
            if (field.isAnnotationPresent(NotEmpty.class)) {
                String value = (String) field.get(obj);  //해당 필드 값을 String으로 가져옴.
                NotEmpty annotation = field.getAnnotation(NotEmpty.class);

                if (value == null || value.trim().isEmpty()) {
                    throw new RuntimeException(annotation.message());  //예외 메시지는 어노테이션에 지정된 message() 값으로 출력.
                }
            }

            // @Range 어노테이션 검사 //
            if (field.isAnnotationPresent(Range.class)) {
                long value = field.getLong(obj);  //해당 필드 값을 long으로 가져옴.
                Range annotation = field.getAnnotation(Range.class);

                if (value < annotation.min() || value > annotation.max()) {
                    throw new RuntimeException(annotation.message());  //예외 메시지는 어노테이션에 지정된 message() 값으로 출력.
                }
            }
        }
    }

}
