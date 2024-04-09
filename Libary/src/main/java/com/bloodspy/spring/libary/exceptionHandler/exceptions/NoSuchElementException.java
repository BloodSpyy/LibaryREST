package com.bloodspy.spring.libary.exceptionHandler.exceptions;


public class NoSuchElementException extends RuntimeException{
    public NoSuchElementException(String nameEntity, int id) {
        super(nameEntity + " with id " + id + " not found");
    }
}
