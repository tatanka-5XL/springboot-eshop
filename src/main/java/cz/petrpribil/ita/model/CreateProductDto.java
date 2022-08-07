package cz.petrpribil.ita.model;

import cz.petrpribil.ita.validator.StartsWithUppercase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class CreateProductDto {
    @NotBlank
    @Size(max=256)
    @StartsWithUppercase(message = "Must start with an uppercase!")
    private String name;
    @NotBlank
    @Size(max=512)
    private String description;
    private String image;
    @NotNull
    @Range
    private Long price;
    @Range
    private Long stock;
}