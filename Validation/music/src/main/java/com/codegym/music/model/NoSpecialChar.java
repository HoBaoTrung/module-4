package com.codegym.music.model;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NoSpecialCharValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoSpecialChar {
    String message() default "Không được chứa ký tự đặc biệt";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}