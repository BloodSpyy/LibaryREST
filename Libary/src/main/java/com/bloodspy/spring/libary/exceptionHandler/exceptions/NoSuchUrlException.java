package com.bloodspy.spring.libary.exceptionHandler.exceptions;

public class NoSuchUrlException extends RuntimeException{
    public NoSuchUrlException(String message) {
        super(message);
    }
}
