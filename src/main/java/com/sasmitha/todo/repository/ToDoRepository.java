package com.sasmitha.todo.repository;

import com.sasmitha.todo.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoEntity, Long> {
    List<ToDoEntity> findByTitle(String title);
}
