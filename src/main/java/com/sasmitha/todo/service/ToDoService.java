package com.sasmitha.todo.service;

import com.sasmitha.todo.dto.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoService {
    boolean create(ToDo toDo);
    Optional<ToDo> searchById(Long id);
    ToDo searchByName(String title);
    boolean update(ToDo toDo);
    boolean delete(Long id);
    List<ToDo> getAll();
}
