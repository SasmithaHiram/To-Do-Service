package com.sasmitha.todo.controller;

import com.sasmitha.todo.dto.ToDo;
import com.sasmitha.todo.service.ToDoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
@CrossOrigin
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody ToDo toDo) {
        boolean isCreated = toDoService.create(toDo);

        if (isCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).body("ToDo has been successfully created");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create ToDO");
        }

    }
}
