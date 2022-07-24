package cz.petrpribil.ita;

import cz.petrpribil.ita.service.ProductService;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class ProductServiceTest {
    private final ProductService productService = new ProductService();

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
