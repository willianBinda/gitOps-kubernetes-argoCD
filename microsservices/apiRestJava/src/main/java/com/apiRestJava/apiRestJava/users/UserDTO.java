package com.apiRestJava.apiRestJava.users;

import com.apiRestJava.apiRestJava.Acesso.Acesso;
import com.apiRestJava.apiRestJava.Acesso.AcessoDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {
    private Long id;

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    private String encryptedPassword;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private AcessoDTO acessoId;
}
