package annotation.mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 애너테이션 만들기 //

@Retention(RetentionPolicy.RUNTIME)
public @interface SimpleMapping {
    String value();
}
