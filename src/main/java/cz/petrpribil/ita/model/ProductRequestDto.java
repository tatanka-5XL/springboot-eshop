package cz.petrpribil.ita.model;

import cz.petrpribil.ita.validation.StartsWithUppercase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    @NotBlank
    @Size(max=256)
    @StartsWithUppercase(message = "Must start with an uppercase!")
    private String name;
    @NotBlank
    @Size(max=512)
    private String description;
    @NotBlank
    private String image;
    @Range(min=1)
    private Long price;
    @Range
    private Long stock;
}