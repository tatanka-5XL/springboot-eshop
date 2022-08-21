package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.CreateProductDto;
import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.model.ProductSimpleDto;

import java.util.Collection;

public interface ProductService {
    ProductDto findProduct(Long id);

    Collection<ProductSimpleDto> findAllProducts();

    ProductDto createProduct(CreateProductDto productDto);

    ProductDto updateProduct(Long id, CreateProductDto productDto);

    void deleteProduct(Long id);
}
