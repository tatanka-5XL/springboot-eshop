package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.exception.ProductNotFoundException;
import cz.petrpribil.ita.mapper.ProductMapper;
import cz.petrpribil.ita.model.CreateProductDto;
import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.repository.ProductRepository;
import cz.petrpribil.ita.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public ProductDto findProduct(Long id) {
        log.info("Fetching product " + id + "...");
        ProductDto product = productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(()-> new ProductNotFoundException(id));
        log.debug("Displayed product " + product);
        return product;
    }

    public Collection<ProductDto> findAllProducts() {
        log.info("Fetching all the products");
        Collection <ProductDto> products = productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
        log.debug("Displayed " + (products.size()) + " products");
        return products;
    }

    public ProductDto createProduct(CreateProductDto productDto) {
        log.debug("Creating product ... ");
        Product product = productMapper.toDomain(productDto);
        Product savedProduct = productRepository.save(product);
        log.debug("Product created: " + mapToDto(savedProduct));
        return mapToDto(savedProduct);
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        log.debug("Product " + id + " is being updated");
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        Product product = mapToDomain(productDto);
        Product savedProduct = productRepository.save(product);
        log.debug("Product was updated as " + mapToDto(savedProduct));
        return mapToDto(savedProduct);
    }

    public void deleteProduct(Long id) {
        log.debug("Product " + id + " was deleted");
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