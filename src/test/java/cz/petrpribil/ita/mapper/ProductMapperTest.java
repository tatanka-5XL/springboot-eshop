package cz.petrpribil.ita.mapper;

import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.model.CreateProductDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static cz.petrpribil.ita.mother.ProductMother.getTestCreateProductDto;
import static cz.petrpribil.ita.mother.ProductMother.getTestProductDto;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {

    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Test
    void toDomain() {
        CreateProductDto productDto = getTestCreateProductDto();
        Product result = productMapper.toDomain(productDto);

        assertThat(result.getName()).isEqualTo(productDto.getName());
        assertThat(result.getDescription()).isEqualTo(productDto.getDescription());
        assertThat(result.getImage()).isEqualTo(productDto.getImage());
        assertThat(result.getPrice()).isEqualTo(productDto.getPrice());
        assertThat(result.getStock()).isEqualTo(productDto.getStock());
    }

    @Test
    void toDto() {

    }

    @Test
    void mergeProduct() {
    }
}