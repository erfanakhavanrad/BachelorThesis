package com.tarazgroup.tws.util.global;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author alireza_bayat
 * @since 2.0.0
 */

public class EnsureNumberValidator implements ConstraintValidator<EnsureNumber, Object> {
    private EnsureNumber ensureNumber;

    @Override
    public void initialize(EnsureNumber constraintAnnotation) {
        this.ensureNumber = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // Check the state of the Adminstrator.
        if (value == null) {
            return false;
        }

        // Initialize it.
        String regex = ensureNumber.decimal() ? "-?[0-9][0-9\\.\\,]*" : "-?[0-9]+";
        String data = String.valueOf(value);
        return data.matches(regex);
    }

}
