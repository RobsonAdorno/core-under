package com.example.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NullObjectException extends RuntimeException {
    public NullObjectException(String message) {
        super(message);
    }
}
