package com.sasmitha.todo.controller;

import com.sasmitha.todo.dto.ToDo;
import com.sasmitha.todo.service.ToDoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo")
@CrossOrigin
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> create(@Valid @RequestBody ToDo toDo) {
        boolean isCreated = toDoService.create(toDo);

        if (isCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).body("ToDo has been successfully created");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create ToDO");
        }
    }

    @GetMapping("/searchById/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<ToDo> searchById(@PathVariable Long id) {
        Optional<ToDo> searched = toDoService.searchById(id);

        if (searched.isPresent()) {
            ToDo toDo = searched.get();
            return ResponseEntity.ok(toDo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/searchByTitle/{title}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<ToDo> searchByTitle(@PathVariable String title) {
        Optional<ToDo> searched = toDoService.searchByTitle(title);

        if (searched.isPresent()) {
            ToDo toDo = searched.get();
            return ResponseEntity.ok(toDo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> update(@Valid @RequestBody ToDo toDo) {
        boolean isUpdated = toDoService.update(toDo);

        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body("ToDo has been updated successfully created");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update ToDO");
        }
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> delete(@Valid @PathVariable Long id) {
        boolean isDeleted = toDoService.delete(id);

        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("ToDo deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete ToDo");
        }
    }

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ToDo>> getAllToDo() {
        List<ToDo> toDoList = toDoService.getAll();

        if (toDoList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(toDoList);
        }
    }
}
