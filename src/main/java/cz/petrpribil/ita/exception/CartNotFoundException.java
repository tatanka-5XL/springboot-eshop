package cz.petrpribil.ita.exception;

import cz.petrpribil.ita.enumeration.ErrorCode;
import org.springframework.http.HttpStatus;

public class CartNotFoundException extends ItaException {
    public CartNotFoundException(Long id) {
        super("Cart " + id + " not found!", ErrorCode.PRODUCT_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
