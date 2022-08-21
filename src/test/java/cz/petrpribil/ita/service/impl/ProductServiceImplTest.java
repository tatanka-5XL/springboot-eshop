package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.exception.ProductNotFoundException;
import cz.petrpribil.ita.mapper.ProductMapper;
import cz.petrpribil.ita.model.ProductRequestDto;
import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.model.ProductSimpleDto;
import cz.petrpribil.ita.repository.ProductRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static cz.petrpribil.ita.mother.ProductMother.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest implements WithAssertions {

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @Mock
    private ProductRepository mockProductRepository;

    @Mock
    private ProductMapper mockProductMapper;


    @Test
    public void testFindProduct(){
        final Product testProduct = getTestProduct();
        when(mockProductRepository.findById(2L)).thenReturn(Optional.of(testProduct));
        ProductDto expectedResult = getTestProductDto();


        when(mockProductMapper.toDto(testProduct))
                .thenReturn(expectedResult);

        ProductDto result = productServiceImpl.findProduct(2L);

        assertThat(result).isEqualTo(expectedResult);

        verify(mockProductRepository).findById(2L);
        verify(mockProductMapper).toDto(testProduct);
    }

    @Test
    public void testProductNotFound(){
        when(mockProductRepository.findById(2L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> productServiceImpl.findProduct(2L))
                .isExactlyInstanceOf(ProductNotFoundException.class);

        verifyNoInteractions(mockProductMapper);
    }

    @Test
    public void testFindAllProducts(){
        Product testProduct1 = getTestProduct();
        Product testProduct2 = getTestProduct();
        ProductDto testProductDto1 = getTestProductDto();
        ProductDto testProductDto2 = getTestProductDto();

        when(mockProductRepository.findAll()).thenReturn(List.of(testProduct1, testProduct2));

        when(mockProductMapper.toDto(testProduct1)).thenReturn(testProductDto1);
        when(mockProductMapper.toDto(testProduct2)).thenReturn(testProductDto2);

        Collection<ProductSimpleDto> resultToApi = productServiceImpl.findAllProducts();

        assertThat(resultToApi).hasSize(2);
        assertThat(resultToApi).contains(testProductDto1);

        verify(mockProductRepository).findAll();
        verify(mockProductMapper).toDto(testProduct1);
        verify(mockProductMapper).toDto(testProduct2);
    }

    @Test
    public void testCreateProduct(){
        Product testProduct = getTestProduct();
        ProductDto testProductDto = getTestProductDto();
        ProductRequestDto testProductRequestDto = getTestCreateProductDto();

        when(mockProductMapper.toDomain(testProductRequestDto)).thenReturn(testProduct);
        when(mockProductRepository.save(testProduct)).thenReturn(testProduct);
        when(mockProductMapper.toDto(testProduct)).thenReturn(testProductDto);

        ProductDto createdProduct = productServiceImpl.createProduct(testProductRequestDto);

        assertThat(createdProduct).isEqualTo(testProductDto);

        verify(mockProductMapper).toDomain(testProductRequestDto);
        verify(mockProductRepository).save(testProduct);
        verify(mockProductMapper).toDto(testProduct);

    }

    @Test
    public void testUpdateProduct() {
        Product testProduct = getTestProduct();
        ProductDto testProductDto = getTestProductDto();
        ProductRequestDto testProductRequestDto = getTestCreateProductDto();
        long id = 1L;

        when(mockProductRepository.findById(id)).thenReturn(Optional.of(testProduct));
        when(mockProductMapper.toDto(testProduct)).thenReturn(testProductDto);

        ProductDto updatedProduct = productServiceImpl.updateProduct(id, testProductRequestDto);

        assertThat(updatedProduct).isEqualTo(testProductDto);

        verify(mockProductRepository).findById(id);
        verify(mockProductMapper).mergeProduct(testProduct, testProductRequestDto);
        verify(mockProductMapper).toDto(testProduct);
    }

        @Test
        public void testUpdatedProductNotFound(){
        ProductRequestDto testProductRequestDto = getTestCreateProductDto();
        long id = 5L;

        when(mockProductRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () -> productServiceImpl.updateProduct(id, testProductRequestDto));

        verify(mockProductRepository).findById(id);
        verifyNoInteractions(mockProductMapper);
    }

    @Test
    public void testDeleteProduct(){
        long id = 1L;

        productServiceImpl.deleteProduct(id);

        verify(mockProductRepository).deleteById(id);
    }

}
