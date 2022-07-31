package cz.petrpribil.ita;

import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.repository.ProductRepository;
import cz.petrpribil.ita.rest.ProductController;
import cz.petrpribil.ita.service.ProductService;
import org.junit.jupiter.api.*;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.*;

public class ProductServiceTest {
        @BeforeEach
    void callInit() {
        productService.init();
    }

    @Test
    @DisplayName("Test if all the products are shown")
    void findAllProducts() {
        assertThat(productService.findAllProducts())
                .as("Check the map size")
                .hasSize(3);
    }

    @Test
    @DisplayName("Test if product is shown, based on its id")
    void findProduct() {
        assertThat(productService.findProduct(3L).getName())
                .as("Check if the last product is Firesteel")
                .isEqualTo("Firesteel");
    }
}
