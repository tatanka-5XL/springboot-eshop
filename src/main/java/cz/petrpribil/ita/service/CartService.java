package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.CartDto;
import cz.petrpribil.ita.model.CartRequestDto;

import java.util.Collection;

public interface CartService {

    CartDto createCart(Long id, CartRequestDto cartRequestDto);
}
