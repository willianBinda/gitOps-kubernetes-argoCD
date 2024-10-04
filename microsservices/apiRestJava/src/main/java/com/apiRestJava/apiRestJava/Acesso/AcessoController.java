package com.apiRestJava.apiRestJava.Acesso;

import com.apiRestJava.apiRestJava.users.UserDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/acessos")
@RequiredArgsConstructor
public class AcessoController {

    private final AcessoService acessoService;

    @PostMapping
    public ResponseEntity<AcessoDTO> cadastrar(@RequestBody @Valid AcessoDTO dto, UriComponentsBuilder uriBuilder){
        System.out.println("=====================");
        System.out.println(dto);
        AcessoDTO acesso = acessoService.criarAcesso(dto);
        URI endereco = uriBuilder.path("acessos/{id}").buildAndExpand(acesso.getId()).toUri();
        return ResponseEntity.created(endereco).body(acesso);

    }
}
