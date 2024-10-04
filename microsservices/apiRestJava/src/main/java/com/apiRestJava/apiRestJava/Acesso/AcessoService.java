package com.apiRestJava.apiRestJava.Acesso;

import com.apiRestJava.apiRestJava.users.User;
import com.apiRestJava.apiRestJava.users.UserDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AcessoService {
    private final AcessoRepository acessoRepository;
    private final ModelMapper modelMapper;

    public AcessoDTO criarAcesso(AcessoDTO dto) {
        Acesso acesso = modelMapper.map(dto,Acesso.class);
        acessoRepository.save(acesso);
        return modelMapper.map(acesso, AcessoDTO.class);
    }
}
