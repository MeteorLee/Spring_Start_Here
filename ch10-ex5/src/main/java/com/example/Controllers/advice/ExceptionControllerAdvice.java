package com.example.Controllers.advice;

import com.example.exceptions.NotEnoughMoneyException;
import com.example.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("결제할 금액이 부족합니다.");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
