package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public ProductDto findProduct() {
        return new ProductDto(
                "Sekera",
                "Super rychle seka, lehka a ucinna",
                "https://www.mall.cz/i/45314226/550/550",
                1500L,
                5L,
                1L
        );
    }
}
