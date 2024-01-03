package com.greensuper.GreenSuper.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class GreenSuperMarketApiException extends RuntimeException{

    private HttpStatus status;
    private String message;
}
