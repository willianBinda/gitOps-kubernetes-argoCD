package com.apiRestJava.apiRestJava.Acesso;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AcessoDTO {
    private Long id;
    @NotBlank
    private String nivel;
    @NotBlank
    private String descricao;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
