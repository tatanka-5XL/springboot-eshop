package cz.petrpribil.ita.exception;

import cz.petrpribil.ita.enumeration.ErrorCode;
import org.springframework.http.HttpStatus;

public class OrderNotFoundException extends ItaException {
    public OrderNotFoundException(Long id) {
        super("Order " + id + " not found!", ErrorCode.ORDER_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}

