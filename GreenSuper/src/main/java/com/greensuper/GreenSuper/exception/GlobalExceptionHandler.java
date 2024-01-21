package com.greensuper.GreenSuper.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public  String HandleResourceNotFoundException(ResourceNotFoundException ex){
        return ex.getMessage();
    }


    @ExceptionHandler(GreenSuperMarketApiException.class)
    public ResponseEntity<ErrorDetails> handleGreenSuperApiException(GreenSuperMarketApiException exception,
                                                                     WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false)
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }


}
