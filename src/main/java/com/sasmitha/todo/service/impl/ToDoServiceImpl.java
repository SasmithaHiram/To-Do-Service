package com.sasmitha.todo.service.impl;

import com.sasmitha.todo.dto.ToDo;
import com.sasmitha.todo.entity.ToDoEntity;
import com.sasmitha.todo.repository.ToDoRepository;
import com.sasmitha.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepository toDoRepository;
    private final ModelMapper modelMapper;

    @Override
    public boolean create(ToDo toDo) {
        log.info("Creating new ToDO: {}", toDo);

        if (toDo == null) {
            return false;
        } else {
            toDoRepository.save(modelMapper.map(toDo, ToDoEntity.class));
            return true;
        }
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
        if (toDo == null || toDo.getId() == null) {
            return false;
        }

        ToDoEntity existing = toDoRepository.findById(toDo.getId()).orElse(null);

        if (existing == null) {
            return false;
        }

        existing.setTitle(toDo.getTitle());
        existing.setDescription(toDo.getDescription());
        existing.setToDoStatus(toDo.getToDoStatus());
        existing.setUpdateAt(LocalDateTime.now());

        toDoRepository.save(existing);

        return true;
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
