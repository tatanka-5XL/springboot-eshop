package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.domain.Cart;
import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.exception.ProductNotFoundException;
import cz.petrpribil.ita.mapper.CartMapper;
import cz.petrpribil.ita.model.CartDto;
import cz.petrpribil.ita.model.CartRequestDto;
import cz.petrpribil.ita.repository.CartRepository;
import cz.petrpribil.ita.repository.ProductRepository;
import cz.petrpribil.ita.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final ProductRepository productRepository;
    private final CartMapper cartMapper;


    @Override
    public CartDto createCart(Long id, CartRequestDto cartDto) {
        log.debug("Creating cart ... ");
        Cart cart = cartMapper.toDomain(cartDto);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        cartRepository.save(cart);
        CartDto savedCart = cartMapper.toDto(cart);
        //get product list to the cart?
        return savedCart;

    }
}
