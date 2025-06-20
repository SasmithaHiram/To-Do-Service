package com.sasmitha.todo.service.impl;

import com.sasmitha.todo.dto.ToDo;
import com.sasmitha.todo.service.ToDoService;

import java.util.List;

public class ToDoServiceImpl implements ToDoService {
    @Override
    public boolean persist(ToDo toDo) {
        return false;
    }

    @Override
    public ToDo searchById(Long id) {
        return null;
    }

    @Override
    public ToDo searchByName(String name) {
        return null;
    }

    @Override
    public boolean update(ToDo toDo) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<ToDo> getAll() {
        return List.of();
    }
}
