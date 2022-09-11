package cz.petrpribil.ita.service.impl;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import cz.petrpribil.ita.configuration.AmazonConfig;
import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.exception.FileNotReadableException;
import cz.petrpribil.ita.exception.ManufacturerNotFoundException;
import cz.petrpribil.ita.exception.ProductGroupNotFoundException;
import cz.petrpribil.ita.exception.ProductNotFoundException;
import cz.petrpribil.ita.mapper.ProductMapper;
import cz.petrpribil.ita.model.PreviewResponse;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
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
    private final AmazonS3 amazonS3;
    private final AmazonConfig amazonConfig;


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

        Product product = productMapper.toDomain(productDto);
        Long manufacturerId = product.getManufacturer().getId();
        manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new ManufacturerNotFoundException(manufacturerId));
        Long productGroupId = product.getProductGroup().getId();
        productGroupRepository.findById(productGroupId)
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

    @Override
    @Transactional
    public void addPreview(Long id, MultipartFile file) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException(id));

        String filename = product.getId() + "_" + file.getOriginalFilename();

        try{
            amazonS3.putObject(amazonConfig.getBucketName(),
                    filename,
                    file.getInputStream(),
                    new ObjectMetadata());

        } catch (IOException e) {
            throw new FileNotReadableException();
        }

        if (product.getPreview() != null) {
            amazonS3.deleteObject(amazonConfig.getBucketName(), product.getPreview());
        }

        product.setPreview(filename);
    }

    @Override
    public PreviewResponse getPreview(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException(id));
        String filename = product.getPreview();

        try{
            S3Object object = amazonS3.getObject(amazonConfig.getBucketName(), filename);
            S3ObjectInputStream objectContent = object.getObjectContent();
            return new PreviewResponse()
                    .setFilename(filename)
                    .setBytes(IOUtils.toByteArray(objectContent));
        } catch (AmazonServiceException | IOException e) {
            throw new FileNotReadableException();
        }
    }
}