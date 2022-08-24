package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.CartDto;
import cz.petrpribil.ita.model.CartRequestDto;


public interface CartService {

    CartDto createCart(Long id, CartRequestDto cartRequestDto);

    CartDto updateCart(Long cart_id, Long id, CartRequestDto cartDto);
}
