package com.sasmitha.todo.service.impl;

import com.sasmitha.todo.dto.ToDo;
import com.sasmitha.todo.entity.ToDoEntity;
import com.sasmitha.todo.exception.InvalidInputException;
import com.sasmitha.todo.exception.ToDoNotFoundException;
import com.sasmitha.todo.repository.ToDoRepository;
import com.sasmitha.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepository toDoRepository;
    private final ModelMapper modelMapper;

    @Override
    public boolean create(ToDo toDo) throws InvalidInputException {
        if (toDo == null || toDo.getTitle() == null || toDo.getTitle().isBlank()) {
            throw new InvalidInputException("Title cannot be null or blank");
        } else {
            toDoRepository.save(modelMapper.map(toDo, ToDoEntity.class));
            return true;
        }
    }

    @Override
    public Optional<ToDo> searchById(Long id) {
        if (id == null) {
            throw new InvalidInputException("Id cannot be null");
        }
        return toDoRepository.findById(id).map(toDoEntity -> modelMapper.map(toDoEntity, ToDo.class)).or(() -> {
            throw new ToDoNotFoundException("No ToDo found with id: " + id);
        });
    }

    @Override
    public Optional<ToDo> searchByTitle(String title) {
        if (title.isEmpty() || title.isBlank()) {
            throw new InvalidInputException("Title cannot be null or blank");
        }
        return toDoRepository.findByTitle(title).map(toDoEntity -> modelMapper.map(toDoEntity, ToDo.class)).or(() -> {
            throw new ToDoNotFoundException("No ToDo found with title: " + title);
        });
    }

    @Override
    public boolean update(ToDo toDo) throws InvalidInputException {
        if (toDo == null || toDo.getId() == null || toDo.getTitle() == null || toDo.getTitle().isBlank()) {
            throw new InvalidInputException("Invalid ToDo input: ID and Title are required");
        }

        ToDoEntity existing = toDoRepository.findById(toDo.getId()).orElseThrow(() -> new InvalidInputException("ToDo not found with Id: " + toDo.getId()));

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
        if (id == null) {
            return false;
        }

        if (toDoRepository.existsById(id)) {
            toDoRepository.deleteById(id);
            return true;
        }
        throw new InvalidInputException("ToDo not found with Id: " +id);
    }

    @Override
    public List<ToDo> getAll() throws ToDoNotFoundException {
        List<ToDoEntity> toDoEntities = toDoRepository.findAll();

        if (toDoEntities.isEmpty()) {
            throw new ToDoNotFoundException("No ToDos found");
        }

        ArrayList<ToDo> toDos = new ArrayList<>();

        toDoEntities.forEach(toDoEntity -> toDos.add(modelMapper.map(toDoEntity, ToDo.class)));
        return toDos;
    }
}
