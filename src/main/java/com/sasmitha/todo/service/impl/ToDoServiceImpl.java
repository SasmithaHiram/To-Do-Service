package com.sasmitha.todo.service.impl;

import com.sasmitha.todo.config.ModelMapper;
import com.sasmitha.todo.dto.ToDo;
import com.sasmitha.todo.repository.ToDoRepository;
import com.sasmitha.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepository toDoRepository;
    private final ModelMapper modelMapper;

    @Override
    public ToDo create(ToDo toDo) {
        return null;
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
