package com.neylton.todo;

import com.neylton.todo.dto.TodoDTO;
import com.neylton.todo.mapper.Converter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoDTO> list() {

        return this.todoRepository.findAll().stream().map(Converter::toTodoDTO).collect(Collectors.toList());
    }

    public TodoDTO findById(long id) {
        TodoEntity todoEntity =  this.todoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Error: Todo not found.")
        );

        return Converter.toTodoDTO(todoEntity);
    }

    public List<TodoDTO> saveOrUpdate(TodoEntity todoEntity) {
        this.todoRepository.save(todoEntity);
        return this.list();
    }

    public List<TodoDTO> delete(long id) {
        this.todoRepository.deleteById(id);
        return this.list();
    }
}
