package cz.petrpribil.ita;

import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.service.ProductService;
import org.junit.jupiter.api.*;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;


public class JUnitTest {
    private final ProductService productService = new ProductService();

    @BeforeEach
    void callInit() {
        productService.init();
    }

    @Test
    @DisplayName("Test if all the products are shown")
    void getAll() {
        callInit();
        Map<Long, ProductDto> productDtoMapTest = ProductService.productDtoMap;
        assertThat(productDtoMapTest.size())
                .as("Check the map size")
                .isEqualTo(3L);
    }

    @Test
    @DisplayName("Test if product is shown, based on its id")
    void findById() {
        callInit();
        assertThat(productService.findProduct(3L).getName())
                .as("Check if the last product is Firesteel")
                .isEqualTo("Firesteel");
    }
}
