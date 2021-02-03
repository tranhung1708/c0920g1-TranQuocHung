package vn.codegym.model;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = CheckIdValidator.class)
@Documented
public @interface RandomId {
    String message() default "ID phải là 1 số có 5 chữ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
