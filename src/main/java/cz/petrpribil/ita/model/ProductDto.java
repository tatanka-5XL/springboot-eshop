package cz.petrpribil.ita.model;

import lombok.*;
import lombok.experimental.Accessors;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class ProductDto {
    private String name;
    private String description;
    private String image;
    private Long price;
    private Long stock;
    private Long id;
}