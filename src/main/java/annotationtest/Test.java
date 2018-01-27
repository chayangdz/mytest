package annotationtest;

import enumtest.DayEnum;

/**
 * Created by chayang on 2017/1/19.
 */
@ColorAnnotation(value = "red", sort = "2", array = {1,2,3}, day = DayEnum.SUN, annotationAttr = @MetaAnnotation("xyz"))
public class Test {

    public static void main(String[] args) {
        if (Test.class.isAnnotationPresent(ColorAnnotation.class)) {
            ColorAnnotation colorAnnotation = Test.class.getAnnotation(ColorAnnotation.class);
            System.out.println(colorAnnotation.value());
            System.out.println(colorAnnotation.sort());
            System.out.println(colorAnnotation.array().length);
            System.out.println(colorAnnotation.annotationAttr().value());


        }
    }
}
