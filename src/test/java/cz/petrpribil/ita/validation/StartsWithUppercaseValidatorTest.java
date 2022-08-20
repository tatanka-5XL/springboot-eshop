package cz.petrpribil.ita.validation;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StartsWithUppercaseValidatorTest implements WithAssertions {

    private final StartsWithUppercaseValidator validator = new StartsWithUppercaseValidator();

    @Test
    public void testIsValid(){
        String testString = "Batoh";
        Boolean result = validator.isValid(testString, null);

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"smallString"})
    @NullAndEmptySource
    public void testIsValidNullString(String testString){
        Boolean result = validator.isValid(testString, null);

        assertThat(result).isFalse();
    }

}
