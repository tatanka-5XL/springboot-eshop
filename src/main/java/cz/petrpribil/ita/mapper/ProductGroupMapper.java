package cz.petrpribil.ita.mapper;

import cz.petrpribil.ita.domain.ProductGroup;
import cz.petrpribil.ita.model.ProductGroupDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProductGroupMapper {
    ProductGroupDto toDto(ProductGroup productGroup);
}
