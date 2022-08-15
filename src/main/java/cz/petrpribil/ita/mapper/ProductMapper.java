package cz.petrpribil.ita.mapper;

import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.model.CreateProductDto;
import cz.petrpribil.ita.model.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface ProductMapper {
    Product toDomain(CreateProductDto productDto);
    ProductDto toDto(Product product);
    void mergeProduct(@MappingTarget Product target, CreateProductDto source);
}
