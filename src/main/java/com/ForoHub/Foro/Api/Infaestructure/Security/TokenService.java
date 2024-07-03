package com.ForoHub.Foro.Api.Infaestructure.Security;


import com.ForoHub.Foro.Api.Domain.Users.UserApi;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generateToken(UserApi userApi) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("MySQLAlura")
                    .withSubject(userApi.getIdemail ())
                    .withClaim("id", userApi.getIduser ())
                    .withExpiresAt(genExpDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    public String getSubject(String token) {
        if (token == null) {
            throw new RuntimeException();
        }
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("MySQLAlura")
                    .build()
                    .verify(token);
            if (verifier.getSubject() == null) {
                throw new RuntimeException("Verifier invalido");
            } else {
                verifier.getSubject ( );
            }
        } catch (JWTVerificationException exception) {
        }
        return verifier.getSubject();
    }

    private Instant genExpDate() {
        return LocalDateTime.now().plusHours(10).toInstant( ZoneOffset.of("-10:00"));
    }
}
