package cz.petrpribil.ita.validation;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {StartsWithUppercaseValidator.class})
@Retention(RUNTIME)
@Target({FIELD, TYPE})
public @interface StartsWithUppercase {
    String message() default ("Wrong input!");
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}
