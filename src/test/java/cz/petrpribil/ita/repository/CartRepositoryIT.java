package cz.petrpribil.ita.repository;

import cz.petrpribil.ita.domain.Cart;
import cz.petrpribil.ita.domain.Product;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static cz.petrpribil.ita.mother.ProductMother.getTestProduct;

import java.util.List;
import java.util.Optional;

@DataJpaTest
class CartRepositoryIT implements WithAssertions {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void testCreateAndRetrieveCart(){

        List<Product> testProducts = List.of(getTestProduct(), getTestProduct());

        Cart testCart = new Cart()
                .setProducts(testProducts);

        testEntityManager.persistAndFlush(testCart);
        testEntityManager.detach(testCart);

        Optional<Cart> result = cartRepository.findById(testCart.getId());

        assertThat(result).isNotEmpty();

        Cart resultCart = result.get();

        assertThat(resultCart.getId()).isEqualTo(testCart.getId());
        assertThat(resultCart.getProducts()).isEqualTo(testCart.getProducts());
    }
}