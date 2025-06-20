package com.sasmitha.todo.controller;

import com.sasmitha.todo.dto.ToDo;
import com.sasmitha.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todo")
@CrossOrigin
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;

    public ResponseEntity<ToDo> create(ToDo toDo) {
        return toDo!=null
                ? ResponseEntity.status(HttpStatus.CREATED).body(toDo)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
