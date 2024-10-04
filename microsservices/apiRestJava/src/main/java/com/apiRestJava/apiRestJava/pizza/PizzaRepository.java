package com.apiRestJava.apiRestJava.pizza;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PizzaRepository extends JpaRepository<Pizza,Long> {

    @Query("""
        select (p.id, p.nome, p.preco, p.disponivel, p.sabor, p.tamanho, p.categoria) from Pizza p
        where lower(p.nome) like lower(concat('%', :query, '%'))
    """)
    Page<Pizza> search(String query, Pageable adj_pageable);
}
