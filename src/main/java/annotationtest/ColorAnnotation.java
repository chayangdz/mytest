package annotationtest;

import enumtest.DayEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by chayang on 2017/1/19.
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface ColorAnnotation {
    String value();
    String sort() default "1";
    int[] array();
    DayEnum day() default DayEnum.MON;
    //注解的元素也可以是注解，可以用default指定默认值
    MetaAnnotation annotationAttr() default @MetaAnnotation("abc");
}
