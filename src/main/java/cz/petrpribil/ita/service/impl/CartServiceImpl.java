package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.domain.Cart;
import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.exception.CartNotFoundException;
import cz.petrpribil.ita.exception.ProductNotFoundException;
import cz.petrpribil.ita.mapper.CartMapper;
import cz.petrpribil.ita.model.CartDto;
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
    public CartDto createCart(Long productId) {
        log.debug("Creating cart with product " + productId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
        Cart cart = new Cart();
        List<Product> products = List.of(product);
        cart.setProducts(products);
        cartRepository.save(cart);
        CartDto savedCart = cartMapper.toDto(cart);
        log.debug("Created cart " + savedCart);
        return savedCart;
    }

    @Override
    @Transactional(readOnly = true)
    public CartDto addToCart(Long cartId, Long productId) {
        log.debug("Cart " + cartId + " is being updated");
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(()-> new CartNotFoundException(cartId));
        Product product = productRepository.findById(productId)
                        .orElseThrow(()-> new ProductNotFoundException(productId));
        List<Product> products = cart.getProducts();
        products.add(product);
        cart.setProducts(products);
        CartDto savedCart = cartMapper.toDto(cart);
        log.debug("Cart was updated by " + products);
        return savedCart;
    }

    @Override
    public CartDto findCart(Long cartId) {
        return cartRepository.findById(cartId)
                .map(cartMapper::toDto)
                .orElseThrow(()-> new CartNotFoundException(cartId));
    }

}

