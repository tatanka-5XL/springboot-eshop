package cz.petrpribil.ita.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ProductDto {
    private String name;
    private String description;
    private String image;
    private Long price;
    private Long stock;
    private Long id;
}