package com.example.taskbase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {NotFountCategory.class})
    public ResponseEntity<?> NotFountCategory(NotFountCategory notFountCategory){
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ApiException apiException = new ApiException(
                notFountCategory.getMessage(),
                notFound);
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {NotEnoughRight.class})
    public ResponseEntity<?> NotEnoughRight(NotEnoughRight notEnoughRight){
        HttpStatus forBidden = HttpStatus.FORBIDDEN;
        ApiException apiException = new ApiException(
                notEnoughRight.getMessage(),
                forBidden);
        return new ResponseEntity<>(apiException, HttpStatus.FORBIDDEN);
    }

}
