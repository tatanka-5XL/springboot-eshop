package cz.petrpribil.ita.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.petrpribil.ita.validation.StartsWithUppercase;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
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
    @NotNull
    @JsonProperty("author")
    private Long manufacturerId;
    @NotNull
    @JsonProperty("genre")
    private Long productGroupId;
}