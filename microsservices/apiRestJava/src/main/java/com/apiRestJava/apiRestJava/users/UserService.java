package com.apiRestJava.apiRestJava.users;

import com.apiRestJava.apiRestJava.Acesso.Acesso;
import com.apiRestJava.apiRestJava.Acesso.AcessoDTO;
import com.apiRestJava.apiRestJava.Acesso.AcessoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;


    public UserDTO criarUser(UserDTO dto) {

        String password_encrypted = passwordEncoder.encode(dto.getEncryptedPassword());
        dto.setEncryptedPassword(password_encrypted);

        User user = modelMapper.map(dto,User.class);
        userRepository.save(user);
        return modelMapper.map(user,UserDTO.class);
    }

}
