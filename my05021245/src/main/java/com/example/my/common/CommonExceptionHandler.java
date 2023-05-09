package com.example.my.common;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){

        //Key에 필드명 , Value에 에러 메시지
        Map<String, String> errorMap = new HashMap<>();
        // 에러가 터진 필드만 골라서 반복문에 넣어줌
        // 익셉션에서 에러 리스트를 찾아서 가공해줌
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

//        return ResDTO.builder()
//                .code(-1)
//                .message("잘못된 요청입니다.")
//                .data(errorMap)
//                .build();
        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(-1)
                        .message("잘못된 요청입니다.")
                        .data(errorMap)
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public HttpEntity<?> handleEntityNotFoundException(Exception e){

        String message = "잘못된 요청입니다.";
        if(e.getMessage() != null && !e.getMessage().equals("")){
            message = e.getMessage();
        }

        return new ResponseEntity<>(
                ResDTO.builder()
                        .code(-1)
                        .message(message)
                        .build()
                ,HttpStatus.BAD_REQUEST
        );
    }


}
