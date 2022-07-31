package cz.petrpribil.ita.service;

import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.repository.ProductRepository;
import cz.petrpribil.ita.rest.ProductController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.stream.Collectors;

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

    public ProductDto createProduct(ProductDto productDto) {
        Product product = mapToDomain(productDto);
        Product savedProduct = productRepository.save(product);
        return mapToDto(savedProduct);
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Product " + id + " not found!");
        }
        Product product = mapToDomain(productDto);
        Product savedProduct = productRepository.save(product);
        return mapToDto(savedProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
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

    private Product mapToDomain(ProductDto product) {
        return new Product()
                .setName(product.getName())
                .setDescription(product.getDescription())
                .setImage(product.getImage())
                .setPrice(product.getPrice())
                .setStock(product.getStock())
                .setId(product.getId());
    }
}