package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.mapper.CartMapper;
import cz.petrpribil.ita.model.CartDto;
import cz.petrpribil.ita.repository.CartRepository;
import cz.petrpribil.ita.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    @Override
    public Collection<CartDto> findAll(){
        return cartRepository.findAll().stream()
                .map(cartMapper::toDto)
                .collect(Collectors.toList());
    }
}
