package com.biki.project.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解里的属性若加了默认值，则外部在调用的时候，就可以不重新赋值
 * 若没加default默认值，则外部调用的时候，一定要赋值，否则报错
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggerTest {

    boolean execution() default true;

    String value() default "1";

}
