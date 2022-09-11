package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.CartDto;
import java.time.LocalDateTime;


public interface CartService {

    /**
     * To create a new cart from clicking on a specific product
     * @param productId
     * @return new cart as {@link CartDto}
     */
    CartDto createCart(Long productId);

    /**
     * To add products to an existing cart
     * @param cartId
     * @param productId
     * @return updated cart with new product as {@link CartDto}
     */
    CartDto addToCart(Long cartId, Long productId);

    /**
     * To find a specific cart stored in the database
     * @param cartId
     * @return cart as a {@link CartDto}
     */
    CartDto findCart(Long cartId);

    /**
     * To remove carts that haven't been converted or modified at than 10 minutes
     */
    public void deleteCartsByModifiedAtBefore(LocalDateTime timeStamp);
}
