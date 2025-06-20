package com.sasmitha.todo.dto;

import com.sasmitha.todo.util.ToDoStatus;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ToDo {
    private Long id;
    private String title;
    private String description;
    private ToDoStatus toDoStatus;
}
