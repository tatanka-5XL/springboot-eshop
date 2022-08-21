package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.ProductRequestDto;
import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.model.ProductSimpleDto;

import java.util.Collection;

public interface ProductService {
    ProductDto findProduct(Long id);

    Collection<ProductSimpleDto> findAllProducts();

    ProductDto createProduct(ProductRequestDto productDto);

    ProductDto updateProduct(Long id, ProductRequestDto productDto);

    void deleteProduct(Long id);
}
