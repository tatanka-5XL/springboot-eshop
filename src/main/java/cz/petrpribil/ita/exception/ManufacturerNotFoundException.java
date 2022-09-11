package cz.petrpribil.ita.exception;

import cz.petrpribil.ita.enumeration.ErrorCode;
import org.springframework.http.HttpStatus;

public class ManufacturerNotFoundException extends ItaException {
    public ManufacturerNotFoundException(Long id) {super("Manufacturer " + id + " not found!", ErrorCode.MANUFACTURER_NOT_FOUND, HttpStatus.NOT_FOUND);}
}
