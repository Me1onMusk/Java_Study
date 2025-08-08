package adv2.annotation.basic;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface AnnoMeta { }

/*
    Retention : 실행 주기
    Target : 적용할 위치
    Document : APi 문서
 */