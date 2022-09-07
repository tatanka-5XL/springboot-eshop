package cz.petrpribil.ita.exception;

import com.amazonaws.services.chime.model.ErrorCode;
import org.springframework.http.HttpStatus;

public class FileNotReadableException extends ItaException {
    public FileNotReadableException() {
        super("File is not readable", ErrorCode.GENERIC_ERROR, HttpStatus.BAD_REQUEST);
    }
}
