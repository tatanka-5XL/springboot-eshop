package cz.petrpribil.ita.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import static java.lang.Character.isUpperCase;

public class StartsWithUppercaseValidator implements ConstraintValidator<StartsWithUppercase, String> {

    @Override
    public void initialize(StartsWithUppercase constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null &&
                !value.isBlank() &&
                Character.isUpperCase(value.codePointAt(0));
    }
}
