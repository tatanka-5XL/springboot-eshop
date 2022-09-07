package cz.petrpribil.ita.exception;

import cz.petrpribil.ita.enumeration.ErrorCode;
import org.springframework.http.HttpStatus;

public class FileNotReadableException extends ItaException {
    public FileNotReadableException() {
        super("File is not readable", ErrorCode.GENERIC_ERROR, HttpStatus.BAD_REQUEST);
    }
}
