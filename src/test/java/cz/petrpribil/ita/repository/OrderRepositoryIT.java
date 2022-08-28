package cz.petrpribil.ita.repository;

import cz.petrpribil.ita.domain.Order;
import cz.petrpribil.ita.repository.OrderRepository;
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
class OrderRepositoryIT implements WithAssertions {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void testCreateAndRetrieveOrder(){

        List<Product> testProducts = List.of(getTestProduct());

        Order testOrder = new Order()
                .setProducts(testProducts);

        testEntityManager.persistAndFlush(testOrder);
        testEntityManager.detach(testOrder);

        Optional<Order> result = orderRepository.findById(testOrder.getId());

        assertThat(result).isNotEmpty();

        Order resultOder = result.get();

        assertThat(resultOder.getId()).isEqualTo(testOrder.getId());
        assertThat(resultOder.getProducts()).isEqualTo(testOrder.getProducts());
    }
}