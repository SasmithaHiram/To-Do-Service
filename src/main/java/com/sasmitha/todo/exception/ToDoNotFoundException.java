package com.sasmitha.todo.exception;

public class ToDoNotFoundException extends RuntimeException {
    public ToDoNotFoundException(String message) {
        super(message);
    }
}
