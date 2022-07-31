package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.ProductDto;

import java.util.Collection;

public interface ProductServiceInterface {
    ProductDto findProduct(Long id);

    Collection<ProductDto> findAllProducts();

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);
}
