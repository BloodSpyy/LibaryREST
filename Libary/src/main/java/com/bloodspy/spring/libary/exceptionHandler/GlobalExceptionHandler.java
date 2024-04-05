package com.bloodspy.spring.libary.exceptionHandler;

import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    ResponseEntity<ContainerExceptionInfo> handleException(NoSuchException exception) {
        ContainerExceptionInfo containerExceptionInfo = new ContainerExceptionInfo();

        containerExceptionInfo.setInfo(exception.getMessage());

        return new ResponseEntity<>(containerExceptionInfo, HttpStatus.NOT_FOUND);
    }
}
