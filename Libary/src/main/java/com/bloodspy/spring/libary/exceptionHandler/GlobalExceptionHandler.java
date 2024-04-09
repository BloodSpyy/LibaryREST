package com.bloodspy.spring.libary.exceptionHandler;

import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchElementException;
import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchUrlException;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    ResponseEntity<ContainerExceptionInfo> handleException(NoSuchElementException exception) {
        ContainerExceptionInfo containerExceptionInfo = new ContainerExceptionInfo();

        containerExceptionInfo.setInfo(exception.getMessage());

        return new ResponseEntity<>(containerExceptionInfo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<ContainerExceptionInfo> handeException(NoSuchUrlException exception) {
        ContainerExceptionInfo containerExceptionInfo = new ContainerExceptionInfo();

        containerExceptionInfo.setInfo(exception.getMessage());

        return new ResponseEntity<>(containerExceptionInfo, HttpStatus.BAD_REQUEST);
    }
}
