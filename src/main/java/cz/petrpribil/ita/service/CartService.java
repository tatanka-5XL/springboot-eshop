package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.CartDto;


public interface CartService {

    CartDto createCart(Long productId);

    CartDto addToCart(Long cartId, Long productId);

    CartDto findCart(Long cartId);
}
