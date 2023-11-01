package com.neylton.todo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDTO {

    private long id;

    @NotNull(message = "Nome da tarefa não pode ser um valor nulo.")
    @NotBlank(message = "Foneça um nome de tarefa com pelo menos 03 caracteres.")
    private String todoName;

    private String description;

    @NotNull(message = "Prioridade da tarefa não pode ser um valor nulo.")
    @Min(value = 0, message = "Prioridade deve ser maior que zero.")
    @Max(value = 5, message = "Prioridade deve ser menor que 5.")
    private int priority;

    @NotNull(message = "Informe se a tarefa está ou não realizada.")
    private boolean done;

}
