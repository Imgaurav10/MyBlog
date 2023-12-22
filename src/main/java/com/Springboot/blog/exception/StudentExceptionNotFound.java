package com.Springboot.blog.exception;

public class StudentExceptionNotFound extends RuntimeException{
    public StudentExceptionNotFound(String message) {
        super(message);
    }

    public StudentExceptionNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentExceptionNotFound(Throwable cause) {
        super(cause);
    }
}
