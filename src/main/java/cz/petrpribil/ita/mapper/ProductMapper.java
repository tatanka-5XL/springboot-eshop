package cz.petrpribil.ita.mapper;

import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.model.CreateProductDto;
import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.model.ProductSimpleDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import javax.transaction.Transactional;

// v pluginu, nastaveni compileru mam naschval defaultcomponentModel jako spring
@Mapper(uses = ManufacturerMapper.class)
public interface ProductMapper {
    Product toDomain(CreateProductDto productDto);
    ProductDto toDto(Product product);
    ProductSimpleDto toSimpleDto(Product product);
    void mergeProduct(@MappingTarget Product target, CreateProductDto source);
}
