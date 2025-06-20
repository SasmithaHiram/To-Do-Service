package com.sasmitha.todo.repository;

import com.sasmitha.todo.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoEntity, Long> {
}
