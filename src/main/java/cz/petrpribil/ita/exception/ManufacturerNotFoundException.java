package cz.petrpribil.ita.exception;

import org.springframework.http.HttpStatus;

public class ManufacturerNotFoundException extends ItaException {
    public ManufacturerNotFoundException(Long id) {super("Manufacturer " + id + " not found!", "0003", HttpStatus.NOT_FOUND);}
}
