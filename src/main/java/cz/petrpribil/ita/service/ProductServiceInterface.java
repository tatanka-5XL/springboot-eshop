package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.ProductDto;

import java.util.Collection;

public interface ProductServiceInterface {
    ProductDto findProduct(Long id);

    Collection<ProductDto> findAllProducts();
}
