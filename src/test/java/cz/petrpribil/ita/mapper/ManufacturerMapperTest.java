package cz.petrpribil.ita.mapper;

import cz.petrpribil.ita.domain.Manufacturer;
import cz.petrpribil.ita.model.ManufacturerDto;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static cz.petrpribil.ita.mother.ManufacturerMother.getTestManufacturer;

public class ManufacturerMapperTest implements WithAssertions {

    private final ManufacturerMapper mockManufacturerMapper = Mappers.getMapper(ManufacturerMapper.class);

    @Test
    void testToDto() {
        Manufacturer testManufacturer = getTestManufacturer();
        ManufacturerDto resultToDomain = mockManufacturerMapper.toDto(testManufacturer);

        assertThat(resultToDomain.getName()).isEqualTo(testManufacturer.getName());
        assertThat(resultToDomain.getAbout()).isEqualTo(testManufacturer.getAbout());
    }

}
