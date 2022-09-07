package cz.petrpribil.ita.exception;

import cz.petrpribil.ita.enumeration.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class ItaException extends RuntimeException {
    private final ErrorCode errorCode;
    private final HttpStatus status;

    public ItaException(String message, ErrorCode errorCode, HttpStatus status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }
}
