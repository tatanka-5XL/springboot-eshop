package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.CartDto;

import java.util.Collection;

public interface CartService {
    Collection<CartDto> findAll();
}
