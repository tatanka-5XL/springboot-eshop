package cz.petrpribil.ita.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.petrpribil.ita.validation.StartsWithUppercase;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;


@Data
@AllArgsConstructor
@NoArgsConstructor
// @Accessors(chain = true) not needed - lombok.config already does (lombok.accessors.chain)
public class ProductDto {
    @NotBlank
    @StartsWithUppercase
    @Length(max = 256)
    private String name;
    @Length(max = 512)
    private String description;
    @NotBlank
    private String image;
    @Positive
    private Long price;
    @Min(0)
    private Long stock;
    private Long id;
    @JsonProperty("author")
    private ManufacturerDto manufacturer;
    @JsonProperty("genre")
    private ProductGroupDto productGroup;
}