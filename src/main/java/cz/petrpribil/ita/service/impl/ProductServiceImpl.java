package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.model.CreateProductDto;
import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.repository.ProductRepository;
import cz.petrpribil.ita.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
//    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    public ProductDto findProduct(Long id) {
        log.debug("XXXXXXXXXXXXXXXXXXX Fetching product " + id + " XXXXXXXXXXXXXXXXXXX");
        return productRepository.findById(id)
        .map(this::mapToDto)
                .orElseThrow(()-> new EntityNotFoundException("Product " + id + " not found!"));
    }

    public Collection<ProductDto> findAllProducts() {
        log.debug("XXXXXXXXXXXXXXXXXXX Showing all the products XXXXXXXXXXXXXXXXXXX");
        return productRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public ProductDto createProduct(CreateProductDto productDto) {
        log.debug("XXXXXXXXXXXXXXXXXXX Creating product ... XXXXXXXXXXXXXXXXXXX");
        Product product = mapToDomain(productDto);
        Product savedProduct = productRepository.save(product);
        log.debug("XXXXXXXXXXXXXXXXXXX Product " + savedProduct.getName() + " created XXXXXXXXXXXXXXXXXXX");
        return mapToDto(savedProduct);
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        log.debug("XXXXXXXXXXXXXXXXXXX Product " + id + " is being updated XXXXXXXXXXXXXXXXXXX");
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Product " + id + " not found!");
        }
        Product product = mapToDomain(productDto);
        Product savedProduct = productRepository.save(product);
        log.debug("XXXXXXXXXXXXXXXXXXX Product " + savedProduct.getName() + " was updated XXXXXXXXXXXXXXXXXXX");
        return mapToDto(savedProduct);
    }

    public void deleteProduct(Long id) {
        log.debug("XXXXXXXXXXXXXXXXXXX Product " + id + " will be deleted XXXXXXXXXXXXXXXXXXX");
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

    private Product mapToDomain(CreateProductDto product) {
        return new Product()
                .setName(product.getName())
                .setDescription(product.getDescription())
                .setImage(product.getImage())
                .setPrice(product.getPrice())
                .setStock(product.getStock());
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