package cz.petrpribil.ita.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

import static java.lang.Character.isUpperCase;

public class StartsWithUppercaseValidator implements ConstraintValidator<StartsWithUppercase, String> {

    @Override
    public boolean isValid(@NotNull @NotBlank String value, ConstraintValidatorContext Context) {
        char c = value.charAt(0);
        return isUpperCase(c);
    }
}
