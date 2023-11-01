package com.neylton.todo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "todo")
@Getter
@Setter
@NoArgsConstructor
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "todo_name")
    private String todoName;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "done")
    private boolean done;

}
