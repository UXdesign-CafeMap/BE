package uxdesign.cafemap.Common.Exception_handler;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import uxdesign.cafemap.Common.Exception.BaseException;
import uxdesign.cafemap.Common.Response.BaseErrorResponse;

import java.io.IOException;

import static uxdesign.cafemap.Common.Response.status.BaseExceptionResponseStatus.*;

@Slf4j
@RestControllerAdvice
public class BaseExceptionControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BaseException.class, NoHandlerFoundException.class, TypeMismatchException.class})
    public BaseErrorResponse handle_BadRequest(Exception e) {
        log.error("[handle_BadRequest]", e);
        return new BaseErrorResponse(URL_NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public BaseErrorResponse handle_HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("[handle_HttpRequestMethodNotSupportedException]", e);
        return new BaseErrorResponse(METHOD_NOT_ALLOWED);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public BaseErrorResponse handle_ConstraintViolationException(ConstraintViolationException e) {
        log.error("[handle_ConstraintViolationException]", e);
        return new BaseErrorResponse(BAD_REQUEST, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public BaseErrorResponse handle_IllegalArgumentException(IllegalArgumentException e) {
        log.error("[handle_IllegalArgumentException]", e);
        return new BaseErrorResponse(BAD_REQUEST, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalStateException.class)
    public BaseErrorResponse handle_IllegalStatusException(IllegalStateException e) {
        log.error("[handle_IllegalStatusException]", e);
        return new BaseErrorResponse(BAD_REQUEST, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IOException.class)
    public BaseErrorResponse handle_IOException(IOException e) {
        log.error("[handle_IOException]", e);
        return new BaseErrorResponse(BAD_REQUEST, e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public BaseErrorResponse handle_RuntimeException(Exception e) {
        log.error("[handle_RuntimeException]", e);
        return new BaseErrorResponse(SERVER_ERROR);
    }
}

