package com.neylton.todo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    Page<TodoEntity> findByTodoNameContainingIgnoreCase(String todoName, Pageable pageable);
    
}
