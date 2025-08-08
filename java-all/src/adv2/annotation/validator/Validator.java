package adv2.annotation.validator;

import java.lang.reflect.Field;

public class Validator {

    public static void validate(Object obj) throws IllegalAccessException {

        Field[] fields = obj.getClass().getDeclaredFields();  // 클래스 필드 가져오기

        // 모든 필드 순회 //
        for(Field field : fields){
            field.setAccessible(true);  //필드에 접근가능

            // 만약 필드에 NotEmpty 클래스의 애노테이션이 존재하면~
            if(field.isAnnotationPresent(NotEmpty.class)) {
                String value = (String) field.get(obj);  //String name 가져오기
                NotEmpty annotation = field.getAnnotation(NotEmpty.class);  //애노테이션 가져오기
                if(value == null || value.isEmpty())
                    throw new RuntimeException(annotation.message());
            }

        }
        

    }

}
