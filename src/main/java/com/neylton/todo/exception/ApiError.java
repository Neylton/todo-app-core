package com.neylton.todo.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ApiError {

    private LocalDateTime timestamp;
    private int code;
    private HttpStatus status;
    private String message;
    private List<String> errors;
    private String path;

    public ApiError(HttpStatus status, String message, List<String> errors, String path) {
        this.timestamp = LocalDateTime.now();
        this.code = status.value();
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.path = path;
    }

    public ApiError(HttpStatus status, String message, String path) {
        this.timestamp = LocalDateTime.now();
        this.code = status.value();
        this.status = status;
        this.message = message;
        this.path = path;
    }

}
