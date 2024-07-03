package com.ForoHub.Foro.Api.Domain.Topico.Respuestas.Validations;

import com.ForoHub.Foro.Api.Domain.Topico.Respuestas.RespuestaData;
import com.ForoHub.Foro.Api.Domain.Topico.Topico.TopicoRepository;
import com.ForoHub.Foro.Api.Domain.Users.UserRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ValidateRespuesta implements InterfValidateRespuesta{

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UserRepository userRepository;

    public void validateRespuesta(RespuestaData respuestaData) {

        validateMessageRespuesta ( respuestaData );
        validateSolucionRespuesta ( respuestaData );
        validateActiveUserRespuesta ( respuestaData );
        validateIdTopicoRespuesta ( respuestaData );
    }

    private void validateMessageRespuesta(RespuestaData respuestaData) {

        if (respuestaData.mensaje ( ).isEmpty ( )) {
            throw new ValidationException ("El mensaje de la respuesta no puede ser nulo.");
        }
    }

    private void validateSolucionRespuesta(RespuestaData respuestaData) {

        if (respuestaData.solucion ( ) == null || (respuestaData.solucion ( ).isEmpty ( ) ) ) {
            throw new ValidationException ("La solucion no puede estar vacia.");
        }
    }

    private void validateActiveUserRespuesta(RespuestaData respuestaData) {

        String ActiveUser = userRepository.getStatusUserId( respuestaData.iduser () );

        if (!Objects.equals ( ActiveUser , "1" )) {
            throw new ValidationException ("Este usuario no se encuentra activo en el sistema.");
        }
    }

    public void validateIdTopicoRespuesta(RespuestaData respuestaData) {

        String existTopico = topicoRepository.getTitleTopicoByIdTopico( respuestaData.idtopico () );

        if (Objects.equals ( existTopico , null )) {
            throw new ValidationException ("El topico seleccionado no existe en la base de datos.");
        }

    }
}
