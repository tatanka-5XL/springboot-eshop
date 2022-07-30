package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductServiceInterface {

    private final ProductRepository productRepository;

    public ProductDto findProduct(Long id) {
        return productDtoMap.get(id);
    }

    public Collection<ProductDto> findAllProducts() {
        return productDtoMap.values();
    }
}
