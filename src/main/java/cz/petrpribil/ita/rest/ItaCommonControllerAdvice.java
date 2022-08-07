package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.exception.ItaException;
import cz.petrpribil.ita.model.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

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

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        ServletWebRequest servletWebRequest = (ServletWebRequest) request;

        log.error("An exception occurred while processing " + servletWebRequest.getRequest().getMethod() + " at " + servletWebRequest.getRequest().getRequestURL(), exception);

        final String errors = exception.getBindingResult().getAllErrors().stream()
                .map(error -> ((FieldError) error).getField() + " " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return handleExceptionInternal(
                exception,
                new ExceptionDto(
                        errors,
                        "0002"
                ),
                new HttpHeaders(),
                status,
                request
        );
    }
}
