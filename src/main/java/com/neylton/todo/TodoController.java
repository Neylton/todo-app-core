package com.neylton.todo;

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
    public List<TodoEntity> list() {
        return this.todoService.list();
    }

    @GetMapping("/{id}")
    public TodoEntity findById(@PathVariable long id) {
        return this.todoService.findById(id);
    }

    @PostMapping
    public List<TodoEntity> saveOrUpdate(@RequestBody TodoEntity todoEntity) {
        return this.todoService.saveOrUpdate(todoEntity);
    }

    @DeleteMapping("/{id}")
    public List<TodoEntity> delete(@PathVariable long id) {
        return this.todoService.delete(id);
    }
}
