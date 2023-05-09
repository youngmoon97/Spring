package com.example.my.common;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(){
    }
    public EntityNotFoundException(String message){
        super(message);
    }

}
