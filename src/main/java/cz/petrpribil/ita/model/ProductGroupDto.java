package cz.petrpribil.ita.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductGroupDto {
    private Long id;
    private String name;
    private String description;
}
