package com.ceiba.error;

import com.ceiba.validator.ValidateObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class ErrorManager extends ResponseEntityExceptionHandler
{
    private static final Logger console = LoggerFactory.getLogger(ErrorManager.class);
    private static final ConcurrentHashMap<String, Integer> STATUS_CODES = new ConcurrentHashMap<>();

    public ErrorManager()
    {
        STATUS_CODES.put(IllegalStateException.class.getSimpleName(), HttpStatus.CONFLICT.value());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllExceptions(Exception exception)
    {
        String nameException = exception.getClass().getSimpleName();
        String message = exception.getMessage();
        Integer code = STATUS_CODES.get(nameException);

        if (ValidateObject.isNull(code))
        {
            console.error(nameException, exception);
            Error error = new Error(nameException, exception.getMessage());
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Error error = new Error(nameException, message);
        return new ResponseEntity<>(error, HttpStatus.valueOf(code));
    }
}