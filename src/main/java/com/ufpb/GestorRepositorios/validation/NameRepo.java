package com.ufpb.GestorRepositorios.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameRepoValidator.class)
@Documented
public @interface NameRepo {
    String message() default "{name repo is invalid, stars with: repo}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
