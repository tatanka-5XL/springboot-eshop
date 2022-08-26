package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.domain.Cart;
import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.exception.CartNotFoundException;
import cz.petrpribil.ita.exception.ProductNotFoundException;
import cz.petrpribil.ita.mapper.CartMapper;
import cz.petrpribil.ita.model.CartDto;
import cz.petrpribil.ita.repository.CartRepository;
import cz.petrpribil.ita.repository.ProductRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static cz.petrpribil.ita.mother.CartMother.getTestCart;
import static cz.petrpribil.ita.mother.CartMother.getTestCartDto;
import static cz.petrpribil.ita.mother.ProductMother.getTestProduct;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CartServiceImplTest implements WithAssertions {

    @InjectMocks
    private CartServiceImpl cartServiceImpl;
    @Mock
    private CartRepository mockCartRepository;
    @Mock
    private ProductRepository mockProductRepository;
    @Mock
    private CartMapper mockCartMapper;
    @Captor
    private ArgumentCaptor<Cart> cartArgumentCaptor;

    @Test
    void testCreateCart(){
        Product testProduct = getTestProduct();
        CartDto testCartDto = getTestCartDto();

        when(mockProductRepository.findById(1L)).thenReturn(Optional.of(testProduct));
        when(mockCartMapper.toDto(any())).thenReturn(testCartDto);

        CartDto createdCart = cartServiceImpl.createCart(1L);

        assertThat(createdCart).isEqualTo(testCartDto);
        verify(mockCartRepository).save(cartArgumentCaptor.capture());

        assertThat(cartArgumentCaptor.getValue().getProducts().contains(testProduct));

        verify(cartArgumentCaptor.getValue().getProducts());
    }

    @Test
    void testCreateCartProductNotFound(){
        when(mockProductRepository.findById(1L))
                .thenReturn(Optional.empty());
        assertThrows(ProductNotFoundException.class, ()-> {
            cartServiceImpl.createCart(1L);
        });

        verifyNoInteractions(mockCartMapper);
        verifyNoInteractions(mockCartRepository);
    }

    @Test
    void testAddToCart(){
        Product testProduct = getTestProduct();
        CartDto testCartDto = getTestCartDto();
        Cart testCart = getTestCart()
                .setProducts(List.of());

        when(mockProductRepository.findById(1L))
                .thenReturn(Optional.of(testProduct));
        when(mockCartMapper.toDto(any()))
                .thenReturn(testCartDto);
        when(mockCartRepository.findById(2L))
                .thenReturn(Optional.of(testCart));

        CartDto updatedCart = cartServiceImpl.addToCart(1L, 2L);

        assertThat(updatedCart).isEqualTo(testCartDto);
        assertThat(testCart.getProducts()).contains(testProduct);
    }

    @Test
    void testAddToCartProductNotFound(){
        Cart testCart = getTestCart();
        when(mockCartRepository.findById(1L))
                .thenReturn(Optional.of(testCart));
        when(mockProductRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, ()-> {
            cartServiceImpl.addToCart(1L, 1L);
        });

        verifyNoInteractions(mockCartMapper);
    }

    @Test
    void testFindCart(){
        Cart testCart = getTestCart();
        CartDto testCartDto = getTestCartDto();

        when(mockCartRepository.findById(1L))
                .thenReturn(Optional.of(testCart));
        when(mockCartMapper.toDto(testCart))
                .thenReturn(testCartDto);

        CartDto result = cartServiceImpl.findCart(1L);

        assertThat(result).isEqualTo(testCartDto);
        verify(mockCartRepository).findById(1L);
        verify(mockCartMapper).toDto(testCart);
    }

    @Test
    void testFindCartIdNotFound(){
        when(mockCartRepository.findById(1L))
                .thenReturn(Optional.empty());


        assertThrows(CartNotFoundException.class, ()-> {
            cartServiceImpl.addToCart(1L, 1L);
        });

        verifyNoInteractions(mockCartMapper);
    }
}
