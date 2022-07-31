package cz.petrpribil.ita;

import cz.petrpribil.ita.repository.ProductRepository;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class ProductServiceTest {

    private ProductRepository mockedProductRepository = mock(ProductRepository.class);


    @Test
    @DisplayName("Test if all the products are shown")
    void findAllProducts() {
        assertThat(mockedProductRepository.findAll())
                .as("Check the product size")
                .hasSize(2);
    }

    @Test
    @DisplayName("Test if product is shown, based on its id")
    void findProduct() {
        assertThat(mockedProductRepository.findById(1L))
                .as("Check if the first product is Sekera")
                .isEqualTo("Sekera");
    }
}
