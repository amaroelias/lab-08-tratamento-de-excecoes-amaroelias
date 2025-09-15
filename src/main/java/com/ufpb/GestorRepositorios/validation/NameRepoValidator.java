package com.ufpb.GestorRepositorios.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameRepoValidator  implements ConstraintValidator<NameRepo, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.startsWith("repo");
    }

}
