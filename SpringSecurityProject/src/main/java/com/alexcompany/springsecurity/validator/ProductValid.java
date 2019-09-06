package com.alexcompany.springsecurity.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ProductValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductValid {
    String message() default "Invalid information";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
