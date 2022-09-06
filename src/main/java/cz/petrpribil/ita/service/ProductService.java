package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.ProductRequestDto;
import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.model.ProductSimpleDto;

import java.util.Collection;

public interface ProductService {

    /**
     * To get complete product info based on its Id, and return it back to API
     * @param id
     * @return product as {@link ProductDto}
     */
    ProductDto findProduct(Long id);

    /**
     * To get collection of all products a return it back to API
     * @return products as {@link Collection<ProductSimpleDto>}
     */
    Collection<ProductSimpleDto> findAllProducts();

    /**
     * To insert a new product into the database
     * @param productDto
     * @return new product as {@link ProductDto}
     */
    ProductDto createProduct(ProductRequestDto productDto);

    /**
     * To change any of product parameters and save that updated product
     * @param id
     * @param productDto
     * @return updated product as {@link ProductDto}
     */
    ProductDto updateProduct(Long id, ProductRequestDto productDto);

    /**
     * To remove complete information about given product
     * @param id
     */
    void deleteProduct(Long id);
}
