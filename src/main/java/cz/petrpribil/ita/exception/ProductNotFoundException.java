package cz.petrpribil.ita.exception;

import cz.petrpribil.ita.enumeration.ErrorCode;
import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends ItaException {
    public ProductNotFoundException(Long id) {
        super("Product " + id + " not found!", ErrorCode.PRODUCT_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
