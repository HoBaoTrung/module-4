package com.codegym.music.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NoSpecialCharValidator implements ConstraintValidator<NoSpecialChar, String> {
    private static final String PATTERN = "^[\\p{L}\\p{N}\\s]+$"; // Chỉ cho chữ, số, khoảng trắng

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches(PATTERN);
    }
}