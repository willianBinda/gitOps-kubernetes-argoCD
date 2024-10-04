package com.apiRestJava.apiRestJava.users;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class AuthUserService implements AuthService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }

    @Override
    public String obterToken(AuthDTO authDTO) {

        User byEmail = userRepository.findByEmail(authDTO.email());

        return gerarTokenJWT(byEmail);
    }

    public String gerarTokenJWT(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256("my-secret-key");
            return JWT.create()
                    .withIssuer("auth-api") //nome qualquer
                    .withSubject(user.getEmail())
                    .withExpiresAt(gerarDataExp())
                    .sign(algorithm);
        }catch (JWTCreationException exeption) {
            throw new RuntimeException("Erro ao tentar gerar o token!");
        }
    }

    private Instant gerarDataExp() {
        return LocalDateTime.now()
                .plusHours(8)
                .toInstant(ZoneOffset.of("-03:00"));
    }

    public String validTokenJWT(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256("my-secret-key");
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException exeption){
            return "";
        }
    }
}
