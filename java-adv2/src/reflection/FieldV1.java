package reflection;

import reflection.data.BasicData;
import java.lang.reflect.Field;

public class FieldV1 {
    public static void main(String[] args) {

        Class<BasicData> helloClass = BasicData.class;

        System.out.println("====== fields() =====");
        Field[] fields = helloClass.getFields();  //모든 public 필드 반환
        for (Field field : fields) {
            System.out.println("field = " + field);
        }
        System.out.println("====== declaredFields() =====");
        Field[] declaredFields = helloClass.getDeclaredFields();  //해당 클래스에 선언된 모든 필드 반환
        for (Field field : declaredFields) {
            System.out.println("declaredField = " + field);
        }

    }
}
