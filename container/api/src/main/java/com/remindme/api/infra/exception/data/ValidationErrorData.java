package com.remindme.api.infra.exception.data;

import org.springframework.validation.FieldError;

public record ValidationErrorData(String field, String message) {
    public ValidationErrorData(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }
}
