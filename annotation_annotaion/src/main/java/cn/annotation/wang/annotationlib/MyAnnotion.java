package cn.annotation.wang.annotationlib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by WANG on 2018/8/7.
 */

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.LOCAL_VARIABLE})
public @interface MyAnnotion {
    String value() default "ssssss";

}

