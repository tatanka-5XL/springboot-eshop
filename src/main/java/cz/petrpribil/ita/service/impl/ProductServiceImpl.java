package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.domain.Manufacturer;
import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.domain.ProductGroup;
import cz.petrpribil.ita.exception.ManufacturerNotFoundException;
import cz.petrpribil.ita.exception.ProductGroupNotFoundException;
import cz.petrpribil.ita.exception.ProductNotFoundException;
import cz.petrpribil.ita.mapper.ProductMapper;
import cz.petrpribil.ita.model.ProductRequestDto;
import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.model.ProductSimpleDto;
import cz.petrpribil.ita.repository.ManufacturerRepository;
import cz.petrpribil.ita.repository.ProductGroupRepository;
import cz.petrpribil.ita.repository.ProductRepository;
import cz.petrpribil.ita.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ManufacturerRepository manufacturerRepository;
    private final ProductGroupRepository productGroupRepository;

    @Override
    @Transactional(readOnly = true)
    public ProductDto findProduct(Long id) {
        log.info("Fetching product " + id + "...");
        ProductDto product = productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(()-> new ProductNotFoundException(id));
        log.debug("Displayed product " + product);
        return product;
    }
    @Override
    @Transactional(readOnly = true)
    public Collection<ProductSimpleDto> findAllProducts() {
        log.info("Fetching all the products");
        Collection <ProductSimpleDto> products = productRepository.findAll().stream()
                .map(productMapper::toSimpleDto)
                .collect(Collectors.toList());
        log.debug("Displayed " + (products.size()) + " products");
        return products;
    }
    @Override
    @Transactional
    public ProductDto createProduct(ProductRequestDto productDto) {
        log.debug("Creating product ... ");
        Product product = productMapper.toDomain(productDto);
        Long manufacturerId = product.getManufacturer().getId();
        Manufacturer checkedManufacturer = manufacturerRepository.findById(manufacturerId)
                        .orElseThrow(() -> new ManufacturerNotFoundException(manufacturerId));
        Long productGroupId = product.getProductGroup().getId();
        ProductGroup checkedProductGroup = productGroupRepository.findById(productGroupId)
                .orElseThrow(() -> new ProductGroupNotFoundException(productGroupId));
        productRepository.save(product);
        ProductDto savedProduct = productMapper.toDto(product);
        log.debug("Product created: " + savedProduct);
        return savedProduct;
    }
    @Override
    @Transactional
    public ProductDto updateProduct(Long id, ProductRequestDto productDto) {
        log.debug("Product " + id + " is being updated");

        Product product = productRepository.findById(id)
                        .orElseThrow(() -> new ProductNotFoundException(id));
        productMapper.mergeProduct(product, productDto);
        ProductDto savedProduct = productMapper.toDto(product);
        log.debug("Product was updated as " + savedProduct);
        return savedProduct;
    }
    @Override
    @Transactional
    public void deleteProduct(Long id) {
        log.debug("Product " + id + " was deleted");
        productRepository.deleteById(id);
    }
}