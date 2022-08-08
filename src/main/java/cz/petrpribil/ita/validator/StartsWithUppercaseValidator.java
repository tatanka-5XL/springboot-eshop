package cz.petrpribil.ita.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

import static java.lang.Character.isUpperCase;

public class StartsWithUppercaseValidator implements ConstraintValidator<StartsWithUppercase, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext Context) {
        char c = value.charAt(0);
        return isUpperCase(c);
    }
}
