package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.domain.Cart;
import cz.petrpribil.ita.domain.Order;
import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.exception.CartNotFoundException;
import cz.petrpribil.ita.mapper.OrderMapper;
import cz.petrpribil.ita.model.OrderDto;
import cz.petrpribil.ita.repository.CartRepository;
import cz.petrpribil.ita.repository.OrderRepository;
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
import static cz.petrpribil.ita.mother.OrderMother.getTestOrderDto;
import static cz.petrpribil.ita.mother.ProductMother.getTestProduct;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest implements WithAssertions {
    @InjectMocks
    private OrderServiceImpl orderServiceImpl;
    @Mock
    private OrderRepository mockOrderRepository;
    @Mock
    private CartRepository mockCartRepository;
    @Mock
    private OrderMapper mockOrderMapper;
    @Captor
    private ArgumentCaptor<Order> orderArgumentCaptor;
    
    @Test
    void testCreateOrder(){
        Product testProduct = getTestProduct();
        OrderDto testOrderDto = getTestOrderDto();
        Cart testCart = getTestCart();
        testCart.setProducts(List.of(testProduct));
        
        when(mockCartRepository.findById(1L)).thenReturn(Optional.of(testCart));
        when(mockOrderMapper.toDto(any())).thenReturn(testOrderDto);

        OrderDto createdOrder = orderServiceImpl.createOrder(1L);

        assertThat(createdOrder).isEqualTo(testOrderDto);
        verify(mockOrderRepository).save(orderArgumentCaptor.capture());

        assertThat(orderArgumentCaptor.getValue().getProducts()).contains(testProduct);
        assertThat(orderArgumentCaptor.getValue().getOrderStatus()).isEqualTo(Order.OrderStatus.NEW);

        verify(mockCartRepository).delete(testCart);
    }

    @Test
    void testCreateOrderCartNotFound(){
        when(mockCartRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(CartNotFoundException.class, ()-> orderServiceImpl.createOrder(1L));
    }

}
