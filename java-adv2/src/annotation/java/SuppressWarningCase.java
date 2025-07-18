package annotation.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SuppressWarningCase {

    @SuppressWarnings("unused")
    public void unusedWarning() {
        // 사용되지 않는 변수 경고 억제
        int unusedVariable = 10;
    }

    @SuppressWarnings("deprecation")
    public void deprecatedMethod() {
        // 더 이상 사용되지 않는 메서도 호출
        Date date = new Date();
        int date1 = date.getDate();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void uncheckedCast() {
        // 제네릭 타입 캐스팅 경고 억제, raw type 사용 경고 
        List list = new ArrayList<>();  //<>는 제네릭(Generic)으로, 타입을 생략하면 "raw type"으로 경고가 발생할 수 있음.

        // 제네릭 타입과 관련된 unchecked 경고
        List<String> stringList = (List<String>) list;
    }

    @SuppressWarnings("all")
    public void suppressAllWarning() {
        // 모든 경고 억제
        Date date = new Date();
        date.getDate();
        List list = new ArrayList<>();
        List<String> stringList = (List<String>) list;
    }
}
