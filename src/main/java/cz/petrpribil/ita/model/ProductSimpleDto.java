package cz.petrpribil.ita.model;

import cz.petrpribil.ita.validation.StartsWithUppercase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSimpleDto {
    @NotBlank
    @StartsWithUppercase
    @Length(max=256)
    private String name;
    @NotBlank
    private String image;
    @Positive
    private Long price;
    private Long id;
}
