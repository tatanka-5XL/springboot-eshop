package cz.petrpribil.ita.exception;

import org.springframework.http.HttpStatus;

public class ProductGroupNotFoundException extends ItaException {
    public ProductGroupNotFoundException(Long id) {super("Product group " + id + " not found!", "0004", HttpStatus.NOT_FOUND);}
}
