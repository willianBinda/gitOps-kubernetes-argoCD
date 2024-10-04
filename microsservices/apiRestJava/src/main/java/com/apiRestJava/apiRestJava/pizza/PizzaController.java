package com.apiRestJava.apiRestJava.pizza;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pizzas")
@RequiredArgsConstructor
public class    PizzaController {
    private final PizzaService pizzaService;
//    @GetMapping
//    public List<PizzaDTO> buscarTodos(){
//        return pizzaService.buscarTodos();
//    }
    @GetMapping
    public ResponseEntity<PaginatePizzaDTO> buscarTodos(@RequestParam(name = "page", defaultValue = "1") Integer page){
//        return pizzaService.buscarTodos(paginacao);


        PaginatePizzaDTO pizzas = pizzaService.buscarTodos(page);
        return ResponseEntity.ok(pizzas);


//        PaginatePizzaDTO pizzas = pizzaService.serachTodo(query, page);
//        return ResponseEntity.ok(pizzas);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PizzaDTO> buscarPorId(@PathVariable @NotNull Long id){
//        return pizzaService.buscarPorId(id);
        PizzaDTO pizzaDTO = pizzaService.buscarPorId(id);
        return ResponseEntity.ok(pizzaDTO);
    }

    @PostMapping
    public ResponseEntity<PizzaDTO> cadastrar(@RequestBody @Valid PizzaDTO dto, UriComponentsBuilder uriBuilder){
        PizzaDTO pizzaDTO = pizzaService.criarPizza(dto);
        URI endereco = uriBuilder.path("/pizzas/{id}").buildAndExpand(pizzaDTO.getId()).toUri();
        return ResponseEntity.created(endereco).body(pizzaDTO);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaDTO> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid PizzaDTO dto){
        PizzaDTO pizzaAtualizada = pizzaService.atualizarPizza(id,dto);
        return ResponseEntity.ok(pizzaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable @NotNull Long id){
        pizzaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
