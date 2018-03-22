package me.hitit.api.controllers;

import me.hitit.api.controllers.responses.DefaultResponse;
import me.hitit.api.exceptions.user.UserConflictException;
import me.hitit.api.exceptions.user.UserNotFoundException;
import me.hitit.api.utils.res.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.security.NoSuchAlgorithmException;

@ControllerAdvice
public class ExceptionContoller {
    @ExceptionHandler(NoSuchAlgorithmException.class)
    public ResponseEntity<?> handleStorageFileNotFound(NoSuchAlgorithmException nsae) {
        DefaultResponse dr = new DefaultResponse(DefaultResponse.Status.FAIL, Strings.CAN_NOT_FOUND_ALGORITHM);
        return new ResponseEntity<>(dr, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<DefaultResponse> userNotFoundExceptionHandler(UserNotFoundException unfe) {
        return new ResponseEntity<>(new DefaultResponse(DefaultResponse.Status.NOT_FOUND, Strings.CAN_NOT_FOUND_USER), HttpStatus.OK);
    }

    @ExceptionHandler(UserConflictException.class)
    public ResponseEntity<?> userConflictException(UserConflictException uce) {
        return new ResponseEntity<>(new DefaultResponse(DefaultResponse.Status.CONFLICT, uce.getMessage()), HttpStatus.OK);
    }
}

