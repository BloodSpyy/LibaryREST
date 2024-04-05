package com.bloodspy.spring.libary.exceptionHandler.exceptions;


public class NoSuchException extends RuntimeException{
    public NoSuchException(String nameEntity, int id) {
        super(nameEntity + " with id " + id + " not found");
    }
}
