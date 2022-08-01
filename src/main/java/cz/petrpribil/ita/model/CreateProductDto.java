package cz.petrpribil.ita.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateProductDto {
    private String name;
    private String description;
    private String image;
    private Long price;
    private Long stock;
}