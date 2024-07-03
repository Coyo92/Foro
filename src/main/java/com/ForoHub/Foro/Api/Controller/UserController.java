package com.ForoHub.Foro.Api.Controller;

import com.ForoHub.Foro.Api.Domain.Users.RegisterUserData;
import com.ForoHub.Foro.Api.Domain.Users.UserApi;
import com.ForoHub.Foro.Api.Domain.Users.UserData;
import com.ForoHub.Foro.Api.Domain.Users.UserRepository;
import com.ForoHub.Foro.Api.Domain.Users.Validations.InterfValidateUsers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
@SecurityRequirement(name = "bearer-key")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    List<InterfValidateUsers> validatorNewUser;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //Register New User
    @PostMapping
    @Transactional
    @Operation(summary = "Registra un nuevo Usuario en la base de datos")
    public ResponseEntity<RegisterUserData> registerTopico(@RequestBody @Valid UserData userData,
                                                           UriComponentsBuilder uriComponentsBuilder) {
        validatorNewUser.forEach ( v ->  v.validateNewUser ( userData ));
        String oldPassword = userData.password ();
        int idUser = userRepository.getSecuenceUser();
        UserApi saveUser = userRepository.save ( new UserApi(userData, idUser, passwordEncoder.encode ( userData.password () ) ) );
        RegisterUserData registerUserData = new RegisterUserData ( saveUser.getIduser (),
                saveUser.getNombre (),
                saveUser.getIdemail (),
                oldPassword,
                saveUser.getIdperfil (),
                saveUser.getStatus (),
                saveUser.getDateregister ());

        URI url = uriComponentsBuilder.path ( "/users/{iduser}" ).buildAndExpand ( saveUser.getIduser () ).toUri ();
        return ResponseEntity.created ( url ).body ( registerUserData );
    }

    //Updating User for ID
    @PutMapping
    @Transactional
    @Operation(summary = "Actualizar Usuario")
    public ResponseEntity updateTopico(@RequestBody @Valid UserData userData) {
        validatorNewUser.forEach ( v ->  v.validateUser ( userData ));
        String oldPassword = userData.password ();
        int idUserByEmal = userRepository.getEmailByIdUser( userData.idemail () );
        UserApi userApi = userRepository.getReferenceById ( (long) idUserByEmal );
        userApi.udpateUserApi ( userData, passwordEncoder.encode ( userData.password () ) );
        return ResponseEntity.ok ( new RegisterUserData ( userApi.getIduser (),
                userApi.getNombre (),
                userApi.getIdemail ( ) ,
                oldPassword,
                userApi.getIdperfil (),
                userApi.getStatus (),
                userApi.getDateregister () ) );
    }
}
