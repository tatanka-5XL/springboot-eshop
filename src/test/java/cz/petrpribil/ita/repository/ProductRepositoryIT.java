package cz.petrpribil.ita.repository;

import cz.petrpribil.ita.domain.Product;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static cz.petrpribil.ita.mother.ProductMother.getTestProduct;


@DataJpaTest
class ProductRepositoryIT implements WithAssertions {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void testCreateAndRetrieveProduct(){

        Product testProduct = getTestProduct();
        testProduct.setId(null);

        testEntityManager.persistAndFlush(testProduct);
        testEntityManager.detach(testProduct);

        Optional<Product> result = productRepository.findById(testProduct.getId());

        assertThat(result).isNotEmpty();

        Product resultProduct = result.get();

        assertThat(resultProduct.getName()).isEqualTo(testProduct.getName());
        assertThat(resultProduct.getDescription()).isEqualTo(testProduct.getDescription());
        assertThat(resultProduct.getImage()).isEqualTo(testProduct.getImage());
        assertThat(resultProduct.getPrice()).isEqualTo(testProduct.getPrice());
        assertThat(resultProduct.getStock()).isEqualTo(testProduct.getStock());
        assertThat(resultProduct.getId()).isEqualTo(testProduct.getId());
    }

}