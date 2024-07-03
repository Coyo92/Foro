package com.ForoHub.Foro.Api.Domain.Users.Validations;

import com.ForoHub.Foro.Api.Domain.Perfil.PerfilRepository;
import com.ForoHub.Foro.Api.Domain.Users.UserApi;
import com.ForoHub.Foro.Api.Domain.Users.UserData;
import com.ForoHub.Foro.Api.Domain.Users.UserRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ValidateUsers implements InterfValidateUsers{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    public void validateNewUser(UserData userData) {
        validateNombreUser( userData );
        validateEmailUser( userData );
        validatePasswordUser( userData );
        validatePerfilUser( userData );
        validateExistUser( userData );
        validateExistEmailUser( userData );
        validateExistPerfilUser( userData );
    }

    public void validateUser(UserData userData) {
        validateNombreUser( userData );
        validateEmailUser( userData );
        validatePasswordUser( userData );
        validatePerfilUser( userData );
        validateExistUser( userData );
        validateNoExistEmailUser( userData );
        validateExistPerfilUser( userData );
    }

    private void validateNombreUser(UserData userData) {

        if (userData.nombre ( ).isEmpty ( )) {
            throw new ValidationException ("El Nombre del usuario no puede ser nulo.");
        }
    }

    private void validateEmailUser(UserData userData) {

        if (userData.idemail ( ).isEmpty ( )) {
            throw new ValidationException ("El Correo del usuario no puede ser nulo.");
        }
    }

    private void validatePasswordUser(UserData userData) {

        if (userData.password ( ).isEmpty ( )) {
            throw new ValidationException ("El password del usuario no puede ser nulo.");
        }
    }

    private void validatePerfilUser(UserData userData) {

        if (userData.idperfil() == 0) {
            throw new ValidationException ("El perfil del usuario no puede ser nulo.");
        }
    }

    private void validateExistUser(UserData userData) {

        UserApi userApi = userRepository.getReferenceById ( (long) userData.iduser () );

        if ( userApi.getIduser () != 0) {
            throw new ValidationException ("Este usuario ya se encuentra registrado en la base de datos.");
        }
    }

    private void validateExistEmailUser(UserData userData) {

        String email = userRepository.getRegisteredEmail ( userData.idemail () );

        if ( !Objects.equals ( email , null ) ) {
            throw new ValidationException ("Este Correo ya se encuentra registrado en la base de datos.");
        }
    }

    private void validateNoExistEmailUser(UserData userData) {

        String email = userRepository.getRegisteredEmail ( userData.idemail () );
        System.out.println ( "email: " + email );

        if ( Objects.equals ( email , null ) ) {
            throw new ValidationException ("Este Correo no se encuentra registrado en la base de datos.");
        }
    }

    private void validateExistPerfilUser(UserData userData) {

        String ActivePerfil = perfilRepository.getStatusPerfilId ( userData.idperfil () );

        if ( ActivePerfil.isEmpty () ) {
            throw new ValidationException ("El Perfil ingresado no se encuentra registrado en la base de datos.");
        }
    }
}
