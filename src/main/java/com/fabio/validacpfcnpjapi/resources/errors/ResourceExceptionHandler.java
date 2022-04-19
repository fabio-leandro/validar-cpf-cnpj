package com.fabio.validacpfcnpjapi.resources.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<FieldErrors> validation(MethodArgumentNotValidException e, HttpServletRequest request){
        FieldErrors fieldErrors = new FieldErrors(HttpStatus.BAD_REQUEST.value(), "Field validation Error.", Instant.now(),
                e.getFieldError().getField(),e.getFieldError().getDefaultMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldErrors);
    }
}
