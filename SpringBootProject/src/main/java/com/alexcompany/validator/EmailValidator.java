package com.alexcompany.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if(email.isEmpty() || !email.contains("@") || !email.contains(".") || email.length() < 5 || email.length() > 100)
            return false;
        int at_index = email.lastIndexOf('@'),
        period_index = email.lastIndexOf('.');
        return at_index < period_index;
    }

    @Override
    public void initialize(EmailConstraint constraintAnnotation) {

    }
}
