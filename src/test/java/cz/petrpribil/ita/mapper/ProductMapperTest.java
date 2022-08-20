package cz.petrpribil.ita.mapper;

import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.model.CreateProductDto;
import cz.petrpribil.ita.model.ProductDto;
import lombok.With;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static cz.petrpribil.ita.mother.ProductMother.getTestCreateProductDto;
import static cz.petrpribil.ita.mother.ProductMother.getTestProductDto;
import static cz.petrpribil.ita.mother.ProductMother.getTestProduct;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ProductMapperTest implements WithAssertions {

    private final ProductMapper mockProductMapper = Mappers.getMapper(ProductMapper.class);

    @Test
    void testToDomain() {
        CreateProductDto productDto = getTestCreateProductDto();
        Product result = mockProductMapper.toDomain(productDto);

        assertThat(result.getName()).isEqualTo(productDto.getName());
        assertThat(result.getDescription()).isEqualTo(productDto.getDescription());
        assertThat(result.getImage()).isEqualTo(productDto.getImage());
        assertThat(result.getPrice()).isEqualTo(productDto.getPrice());
        assertThat(result.getStock()).isEqualTo(productDto.getStock());
    }

    @Test
    void testToDto() {
        Product testProduct = getTestProduct();
        ProductDto resultToDomain = mockProductMapper.toDto(testProduct);

        assertThat(resultToDomain.getName()).isEqualTo(testProduct.getName());
        assertThat(resultToDomain.getDescription()).isEqualTo(testProduct.getDescription());
        assertThat(resultToDomain.getImage()).isEqualTo(testProduct.getImage());
        assertThat(resultToDomain.getPrice()).isEqualTo(testProduct.getPrice());
        assertThat(resultToDomain.getStock()).isEqualTo(testProduct.getStock());

    }

    @Test
    void testMergeProduct() {
        CreateProductDto testCreateProductDto = getTestCreateProductDto();
        Product resultToDomain = getTestProduct();
        mockProductMapper.mergeProduct(resultToDomain, testCreateProductDto);

        assertThat(resultToDomain.getName()).isEqualTo(testCreateProductDto.getName());
        assertThat(resultToDomain.getDescription()).isEqualTo(testCreateProductDto.getDescription());
        assertThat(resultToDomain.getImage()).isEqualTo(testCreateProductDto.getImage());
        assertThat(resultToDomain.getPrice()).isEqualTo(testCreateProductDto.getPrice());
        assertThat(resultToDomain.getStock()).isEqualTo(testCreateProductDto.getStock());    }
}