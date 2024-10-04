package com.apiRestJava.apiRestJava.pizza;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    private  final ModelMapper modelMapper;

    public PaginatePizzaDTO buscarTodos(Integer page) {
        int def_page = page < 1 ? 0 : page - 1;
        Pageable adj_pageable = PageRequest.of(def_page, 10, Sort.Direction.DESC, "id");

        return new PaginatePizzaDTO(
                pizzaRepository.findAll(adj_pageable)
                    .map(p -> modelMapper.map(p, PizzaDTO.class))
        );
    }



///////////////////////////////////

    public PizzaDTO buscarPorId(Long id) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return  modelMapper.map(pizza, PizzaDTO.class);
    }

    public PizzaDTO criarPizza(PizzaDTO dto) {
        Pizza pizza = modelMapper.map(dto, Pizza.class);
        pizzaRepository.save(pizza);
        return modelMapper.map(pizza, PizzaDTO.class);
    }

    public PizzaDTO atualizarPizza(Long id, PizzaDTO dto) {

        Pizza pizza = modelMapper.map(dto, Pizza.class);
        pizza.setId(id);
        pizza = pizzaRepository.save(pizza);
        return modelMapper.map(pizza, PizzaDTO.class);

    }

    public void excluir(Long id) {
        pizzaRepository.deleteById(id);
    }


}