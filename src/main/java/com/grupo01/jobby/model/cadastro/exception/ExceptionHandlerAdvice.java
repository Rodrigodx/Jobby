package com.grupo01.jobby.model.cadastro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> catchError500(EntityNotFoundException error) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> catchError400(MethodArgumentNotValidException error) {
        var errors = error.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DadosErros::new).toList());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> catchError400(MethodArgumentTypeMismatchException error) {
        return ResponseEntity.badRequest().body("O tipo fornecido não é compativel.");
    }

    private record DadosErros(String campo, String mensagem) {
        public DadosErros(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }

    }


}
