package com.apiRestJava.apiRestJava.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String auth(@RequestBody AuthDTO dto){
        var usuarioAuhtenticadoToken = new UsernamePasswordAuthenticationToken(dto.email(),dto.senha());
        authenticationManager.authenticate(usuarioAuhtenticadoToken);
        return authService.obterToken(dto);
    }

}
