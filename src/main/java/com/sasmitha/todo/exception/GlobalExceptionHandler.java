package com.sasmitha.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ToDoNotFoundException.class)
    ResponseEntity<ErrorResponse> handleToDoNotFoundException(ToDoNotFoundException toDoNotFoundException) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(toDoNotFoundException.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    ResponseEntity<ErrorResponse> handleInvalidInputException(InvalidInputException invalidInputException) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(invalidInputException.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
