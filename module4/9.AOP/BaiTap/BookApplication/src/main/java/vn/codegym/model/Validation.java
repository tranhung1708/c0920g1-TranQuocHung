package vn.codegym.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class CheckIdValidator implements ConstraintValidator<RandomId, Long> {
    public void initialize(RandomId randomId) {
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return value != 0;
    }
}
