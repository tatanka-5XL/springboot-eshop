package cz.petrpribil.ita.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSimpleDto {
    private String name;
    private String image;
    private Long price;
    private Long id;
}
