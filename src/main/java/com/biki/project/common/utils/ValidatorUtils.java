package com.biki.project.common.utils;

import com.biki.project.common.exception.UnifiedException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2021/1/20
 */
public class ValidatorUtils {

    private static javax.validation.Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     *若DTO、VO等加了validation的注解，如@NotBlank、@NotNull等
     * 就可以调用该方法，对DTO里面的属性就行校验
     * @param t DTO、VO等加了对象validation注解的对象
     */
    public static void valid(Object t) {

        Set<ConstraintViolation<Object>> violations = validator.validate(t);
        if (violations.size() > 0) {
            throw UnifiedException.from(toString(violations));
        }
    }


    private static String toString(Set<? extends ConstraintViolation<?>> constraintViolations) {
        return constraintViolations.stream()
                .map( cv -> cv == null ? "null" : cv.getPropertyPath() + ": " + cv.getMessage() )
                .collect( Collectors.joining( ", " ) );
    }



}
