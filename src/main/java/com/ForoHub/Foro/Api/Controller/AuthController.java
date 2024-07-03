package com.ForoHub.Foro.Api.Controller;

import com.ForoHub.Foro.Api.Domain.Users.AuthenticationUserData;
import com.ForoHub.Foro.Api.Domain.Users.UserApi;
import com.ForoHub.Foro.Api.Infaestructure.Security.DataJWTToken;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import com.ForoHub.Foro.Api.Infaestructure.Security.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Tag(name = "Autenticacion", description = "obtiene el token para el usuario asignado que da acceso al resto de endpoint")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticateUser(@RequestBody @Valid AuthenticationUserData authenticationUserData) {
        Authentication authToken = new UsernamePasswordAuthenticationToken (//"alberto@gmail.com",
                                                                            authenticationUserData.idemail (),
                                                                            authenticationUserData.password()
                                                                            );
        var AuthenticatedUser = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generateToken ((UserApi) AuthenticatedUser.getPrincipal());
        return ResponseEntity.ok(new DataJWTToken (JWTtoken));
    }
}
