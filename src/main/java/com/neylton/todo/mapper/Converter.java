package com.neylton.todo.mapper;

import com.neylton.todo.TodoEntity;
import com.neylton.todo.dto.TodoDTO;
import org.modelmapper.ModelMapper;

public final class Converter {

    private static final ModelMapper mapper = new ModelMapper();

    public static TodoEntity ToTodoEntity(TodoDTO todoDTO) {
        return mapper.map(todoDTO, TodoEntity.class);
    }

    public static TodoDTO toTodoDTO(TodoEntity todoEntity) {
        return mapper.map(todoEntity, TodoDTO.class);
    }

}
