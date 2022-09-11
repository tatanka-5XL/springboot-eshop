package cz.petrpribil.ita.exception;

import cz.petrpribil.ita.enumeration.ErrorCode;
import org.springframework.http.HttpStatus;

public class ProductGroupNotFoundException extends ItaException {
    public ProductGroupNotFoundException(Long id) {super("Product group " + id + " not found!", ErrorCode.PRODUCT_NOT_FOUND, HttpStatus.NOT_FOUND);}
}
