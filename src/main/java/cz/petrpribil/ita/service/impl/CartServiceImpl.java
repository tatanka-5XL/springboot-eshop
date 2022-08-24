package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.domain.Cart;
import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.exception.CartNotFoundException;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final ProductRepository productRepository;
    private final CartMapper cartMapper;


    @Override
    @Transactional
    public CartDto createCart(Long id, CartRequestDto cartDto) {
        log.debug("Creating cart ... ");
        Cart cart = cartMapper.toDomain(cartDto);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        List<Product> products = List.of(product);
        cart.setProducts(products); // is it correct?
        cartRepository.save(cart);
        CartDto savedCart = cartMapper.toDto(cart);
        return savedCart;
    }

    @Override
    @Transactional
    public CartDto updateCart(Long cart_id, Long id, CartRequestDto cartDto) {
        log.debug("Cart " + cart_id + " is being updated");
        Cart cart = cartRepository.findById(cart_id)
                .orElseThrow(()-> new CartNotFoundException(cart_id));
        Product product = productRepository.findById(id)
                        .orElseThrow(()-> new ProductNotFoundException(id));
        List<Product> products = cart.getProducts();
        products.add(product);
        cart.setProducts(products); // is it correct?
        cartMapper.mergeCart(cart, cartDto);
        CartDto savedCart = cartMapper.toDto(cart);
        log.debug("Cart was updated as " + savedCart);
        return null;
    }


}

