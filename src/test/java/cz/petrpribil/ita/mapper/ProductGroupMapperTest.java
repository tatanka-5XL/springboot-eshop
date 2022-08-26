package cz.petrpribil.ita.mapper;

import cz.petrpribil.ita.domain.ProductGroup;
import cz.petrpribil.ita.model.ProductGroupDto;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static cz.petrpribil.ita.mother.ProductGroupMother.getTestProductGroup;

public class ProductGroupMapperTest implements WithAssertions {

    private final ProductGroupMapper mockProductGroupMapper = Mappers.getMapper(ProductGroupMapper.class);

    @Test
    void testToDto() {
        ProductGroup testProductGroup = getTestProductGroup();
        ProductGroupDto resultToDomain = mockProductGroupMapper.toDto(testProductGroup);

        assertThat(resultToDomain.getName()).isEqualTo(testProductGroup.getName());
        assertThat(resultToDomain.getDescription()).isEqualTo(testProductGroup.getDescription());
    }

}
