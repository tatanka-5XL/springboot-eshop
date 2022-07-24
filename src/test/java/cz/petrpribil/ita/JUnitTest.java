package cz.petrpribil.ita;

import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collection;


public class JUnitTest {
    private final Collection<ProductDto> testingCollection = ProductService.findAllProducts();
    private final ProductDto testingProduct = ProductService.findProduct(3L);
    @Test
    @DisplayName("Test if all the products are shown")
    void getAll() {
//        ProductService productService = new ProductService();
//        System.out.println(productService);
//        Assertions.assertEquals(3L, productService.findAllProducts());
        Assertions.assertEquals(3, testingCollection.size());
    }

    @Test
    @DisplayName("Test if one product is found by its id")
    void findById() {
        Assertions.assertEquals("Firesteel", testingProduct.getName());
    }
}
