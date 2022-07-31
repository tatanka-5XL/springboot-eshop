package cz.petrpribil.ita.service;

import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
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
        return productRepository.findById(id)
        .map(this::mapToDto)
                .orElseThrow(()-> new EntityNotFoundException("Product " + id + " not found!"));
    }

    public Collection<ProductDto> findAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }


    private ProductDto mapToDto(Product product) {
        return new ProductDto(
                product.getName(),
                product.getDescription(),
                product.getImage(),
                product.getPrice(),
                product.getStock(),
                product.getId()
        );
    }
}