package com.sasmitha.todo.service;

import com.sasmitha.todo.dto.ToDo;

import java.util.List;

public interface ToDoService {
    ToDo create(ToDo toDo);
    ToDo searchById(Long id);
    ToDo searchByName(String name);
    boolean update(ToDo toDo);
    boolean delete(Long id);
    List<ToDo> getAll();
}
