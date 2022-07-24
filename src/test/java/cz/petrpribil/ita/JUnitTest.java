package cz.petrpribil.ita;

import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.service.ProductService;
import org.junit.Before;
import org.junit.jupiter.api.*;

import java.util.Collection;
import java.util.Map;


public class JUnitTest {
    private final ProductService productService = new ProductService();

//    private final Map<Long, ProductDto> productDtoMapTest = productService.productDtoMap;

    @BeforeEach
    void callInit() {
        productService.init();
    }

    @Test
    @DisplayName("Test if all the products are shown")
    void getAll() {
        callInit();
        Map<Long, ProductDto> productDtoMapTest = productService.productDtoMap;
        Assertions.assertEquals(3, productDtoMapTest.size());
    }

    @Test
    @DisplayName("Test if product is shown, based on its id")
    void findById() {
        callInit();
        Map<Long, ProductDto> productDtoMapTest = productService.productDtoMap;
        Assertions.assertEquals("Firesteel", productService.findProduct(3L));
    }
}
