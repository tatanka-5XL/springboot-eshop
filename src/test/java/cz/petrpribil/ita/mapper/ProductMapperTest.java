package cz.petrpribil.ita.mapper;

import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.model.ProductRequestDto;
import cz.petrpribil.ita.model.ProductDto;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static cz.petrpribil.ita.mother.ProductMother.getTestCreateProductDto;
import static cz.petrpribil.ita.mother.ProductMother.getTestProduct;


class ProductMapperTest implements WithAssertions {

    private final ProductMapper mockProductMapper = Mappers.getMapper(ProductMapper.class);

    @Test
    void testToDomain() {
        ProductRequestDto productDto = getTestCreateProductDto();
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
        ProductRequestDto testProductRequestDto = getTestCreateProductDto();
        Product resultToDomain = getTestProduct();
        mockProductMapper.mergeProduct(resultToDomain, testProductRequestDto);

        assertThat(resultToDomain.getName()).isEqualTo(testProductRequestDto.getName());
        assertThat(resultToDomain.getDescription()).isEqualTo(testProductRequestDto.getDescription());
        assertThat(resultToDomain.getImage()).isEqualTo(testProductRequestDto.getImage());
        assertThat(resultToDomain.getPrice()).isEqualTo(testProductRequestDto.getPrice());
        assertThat(resultToDomain.getStock()).isEqualTo(testProductRequestDto.getStock());
    }
}