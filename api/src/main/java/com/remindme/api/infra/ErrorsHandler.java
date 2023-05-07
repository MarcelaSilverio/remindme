package com.remindme.api.infra;

import com.remindme.api.infra.data.ValidationErrorData;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErrorsHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity treatNotFoundError() {
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity treatBadRequestError(MethodArgumentNotValidException exception) {
        List<FieldError> errors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(ValidationErrorData::new).toList());
    }
}
