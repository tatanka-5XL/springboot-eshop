package cz.petrpribil.ita.mapper;

import cz.petrpribil.ita.domain.Manufacturer;
import cz.petrpribil.ita.model.ManufacturerDto;
import org.mapstruct.Mapper;

@Mapper
public interface ManufacturerMapper {
    ManufacturerDto toDto(Manufacturer manufacturer);
}
