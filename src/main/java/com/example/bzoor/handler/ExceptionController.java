package com.example.bzoor.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = deleteException.class)
    public ResponseEntity<Object> handelYaHoop(HttpServletRequest req, Exception ex){
        System.out.printf("hi arafat");
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        deleteExceptionShape deleteExceptionShape = new deleteExceptionShape(ex.getMessage(),ex, badRequest, ZonedDateTime.now(ZoneId.of("Z")));
        ResponseEntity<Object> re = new ResponseEntity<>(deleteExceptionShape, badRequest);
        return re;
    }
}


