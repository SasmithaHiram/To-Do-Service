package com.sasmitha.todo.controller;

import com.sasmitha.todo.dto.ToDo;
import com.sasmitha.todo.service.ToDoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PutMapping("/update")
    public ResponseEntity<String> update(@Valid @RequestBody ToDo toDo) {
        boolean isUpdated = toDoService.update(toDo);

        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.CREATED).body("ToDo has been updated successfully created");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update ToDO");
        }
    }

    @GetMapping("/searchById/{id}")
    public ResponseEntity<ToDo> searchById(@PathVariable Long id) {
        Optional<ToDo> searched = toDoService.searchById(id);

        if (searched.isPresent()) {
            ToDo toDo = searched.get();
            return ResponseEntity.ok(toDo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
