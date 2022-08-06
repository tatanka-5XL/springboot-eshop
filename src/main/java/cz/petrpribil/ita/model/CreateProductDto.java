package cz.petrpribil.ita.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class CreateProductDto {
    @NotBlank
    @Size(max=256)
    private String name;
    @NotBlank
    @Size(max=512)
    private String description;
    private String image;
    @NotNull
    @Size
    private Long price;
    @Size
    private Long stock;
}