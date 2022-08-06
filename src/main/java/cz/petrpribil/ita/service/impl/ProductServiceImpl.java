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
        log.debug("Fetching product " + id + "...");
        return productRepository.findById(id)
        .map(this::mapToDto)
                .orElseThrow(()-> new EntityNotFoundException("Product " + id + " not found!"));
    }

    public Collection<ProductDto> findAllProducts() {
        log.debug("Fetching all the products");
        return productRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public ProductDto createProduct(CreateProductDto productDto) {
        log.debug("Creating product ... ");
        Product product = mapToDomain(productDto);
        Product savedProduct = productRepository.save(product);
        log.debug("Product created: " + mapToDto(savedProduct).toString());
        return mapToDto(savedProduct);
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        log.debug("Product " + id + " is being updated");
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Product " + id + " not found!");
        }
        Product product = mapToDomain(productDto);
        Product savedProduct = productRepository.save(product);
        log.debug("Product was updated as " + mapToDto(savedProduct).toString());
        return mapToDto(savedProduct);
    }

    public void deleteProduct(Long id) {
        log.debug("XXXXXXXXXXXXXXXXXXX Product " + id + " was deleted XXXXXXXXXXXXXXXXXXX");
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