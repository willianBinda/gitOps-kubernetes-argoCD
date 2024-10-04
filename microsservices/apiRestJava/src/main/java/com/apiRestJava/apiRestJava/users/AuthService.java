package com.apiRestJava.apiRestJava.users;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    public String obterToken(AuthDTO authDTO);

    public String validTokenJWT(String token);
}
