package com.neylton.todo;

import com.neylton.todo.dto.TodoDTO;
import com.neylton.todo.mapper.Converter;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<TodoDTO> list() {
        return this.todoService.list();
    }

    @GetMapping("/{id}")
    public TodoDTO findById(@PathVariable long id) {
        return this.todoService.findById(id);
    }

    @PostMapping
    public List<TodoDTO> saveOrUpdate(@Valid @RequestBody TodoDTO todo) {
        return this.todoService.saveOrUpdate(Converter.ToTodoEntity(todo));
    }

    @DeleteMapping("/{id}")
    public List<TodoDTO> delete(@PathVariable long id) {
        return this.todoService.delete(id);
    }
}
