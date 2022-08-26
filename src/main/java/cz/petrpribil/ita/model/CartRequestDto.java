package cz.petrpribil.ita.model;

import cz.petrpribil.ita.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartRequestDto {
    private List<Product> products;
}
