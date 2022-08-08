package cz.petrpribil.ita;

import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.exception.ProductNotFoundException;
import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.repository.ProductRepository;
import cz.petrpribil.ita.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.when;
import static cz.petrpribil.ita.mother.ProductMother.getTestProducts;
import static cz.petrpribil.ita.mother.ProductMother.getTestProduct;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @Mock
    private ProductRepository mockProductRepository;

    @Test
    public void testFindAllProducts(){
        when(mockProductRepository.findAll()).thenReturn(getTestProducts());
        Collection<ProductDto> allProducts = productServiceImpl.findAllProducts();

        assertThat(allProducts.size()).isEqualTo(2L);
    }

    @Test
    public void testFindProduct(){
        final Product testProduct = getTestProduct();
        when(mockProductRepository.findById(2L)).thenReturn(Optional.of(testProduct));
        ProductDto finalProduct = productServiceImpl.findProduct(2L);
        assertThat(finalProduct.getName()).isEqualTo("Batoh");
    }

    @Test
    public void testProductNotFound(){
        when(mockProductRepository.findById(2L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> productServiceImpl.findProduct(2L))
                .isExactlyInstanceOf(ProductNotFoundException.class);
    }

}
