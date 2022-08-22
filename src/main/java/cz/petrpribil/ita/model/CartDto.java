package cz.petrpribil.ita.model;

import cz.petrpribil.ita.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    List<Product> products;
    private Long id;
}
