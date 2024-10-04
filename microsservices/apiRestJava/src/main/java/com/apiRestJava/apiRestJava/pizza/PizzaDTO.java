package com.apiRestJava.apiRestJava.pizza;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PizzaDTO {
    private Long id;
    @NotBlank
    private String nome;
    @Positive
    private double preco;
    private boolean disponivel;
    private Sabor sabor;
    private Tamanho tamanho;
    private Categoria categoria;
}
