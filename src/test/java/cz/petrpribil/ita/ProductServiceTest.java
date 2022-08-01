package cz.petrpribil.ita;

import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.repository.ProductRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @Mock
    private ProductRepository mockedProductRepository;

    @BeforeTestMethod
    public void beforeMethod() {
        mockedProductRepository = mock(ProductRepository.class);
    }

    public List<ProductDto> dataProvider() {
        ProductDto product1 = new ProductDto ("Lahev","Velka","some_url_1",100L,5L, 1L);
        ProductDto product2 = new ProductDto ("Batoh","Maly","some_url_2",200L,10L, 2L);
        List<ProductDto> someList = Arrays.asList(product1, product2);
        return someList;
    }

// v assertu musim volat servisu a ne repository
    @Test
    @DisplayName("Test if all the products are shown")
    void findAllProducts() {
        when(mockedProductRepository.findAll()).thenReturn(dataProvider());

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
