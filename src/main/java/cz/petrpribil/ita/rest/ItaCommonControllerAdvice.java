package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.exception.ItaException;
import cz.petrpribil.ita.model.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Component
@ControllerAdvice
@Slf4j
public class ItaCommonControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ItaException.class)
    public ResponseEntity<Object> handleItaException(
        ItaException ex,
        ServletWebRequest request
    ){
        log.error("An exception occurred while processing " + request.getRequest().getMethod() + " at " + request.getRequest().getRequestURL(), ex);

        return handleExceptionInternal(
                ex,
                new ExceptionDto(
                    ex.getMessage(),
                    ex.getCode()
                ),
                new HttpHeaders(),
                ex.getStatus(),
                request
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUnexpectedException(
            Exception ex,
            ServletWebRequest request
    ) {
        log.error("An exception occurred while processing " + request.getRequest().getMethod() + " at " + request.getRequest().getRequestURL(), ex);

        return handleExceptionInternal(
                ex,
                new ExceptionDto(
                        ex.getMessage(),
                        "0000"
                ),
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                request
        );
    }
}
