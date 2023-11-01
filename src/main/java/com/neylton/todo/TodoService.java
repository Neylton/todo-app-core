package com.neylton.todo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoEntity> list() {
        return this.todoRepository.findAll();
    }

    public TodoEntity findById(long id) {
        return this.todoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Error: Todo not found.")
        );
    }

    public List<TodoEntity> saveOrUpdate(TodoEntity todoEntity) {
        this.todoRepository.save(todoEntity);
        return this.list();
    }

    public List<TodoEntity> delete(long id) {
        this.todoRepository.delete(this.findById(id));
        return this.list();
    }
}
