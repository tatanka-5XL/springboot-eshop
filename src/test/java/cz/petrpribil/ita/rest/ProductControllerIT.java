package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.domain.ProductGroup;
import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.repository.ManufacturerRepository;
import cz.petrpribil.ita.repository.ProductGroupRepository;
import cz.petrpribil.ita.repository.ProductRepository;
import cz.petrpribil.ita.service.ProductService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static cz.petrpribil.ita.mother.ProductMother.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerIT implements WithAssertions {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private ProductGroupRepository productGroupRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private ProductRepository productRepository;


    @Test
    void testFindProduct(){

        Product product = getTestProduct();
        product.setId(null);
        product.setManufacturer(manufacturerRepository.findById(1L).get());
        product.setProductGroup(productGroupRepository.findById(1L).get());

        productRepository.save(product);

        ResponseEntity<ProductDto> response = testRestTemplate.getForEntity("/api/v1/products/", ProductDto.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        ProductDto body = response.getBody();

        assertThat(body).isNotNull();
        assertThat(body.getName()).isEqualTo(product.getName());

        productRepository.deleteById(product.getId());  // v integracnich testech po sobe vzdy uklidit!
    }
}