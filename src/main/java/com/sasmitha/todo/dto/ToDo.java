package com.sasmitha.todo.dto;

import com.sasmitha.todo.util.ToDoStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ToDo {
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @NotNull(message = "Status is required")
    private ToDoStatus toDoStatus;
}
