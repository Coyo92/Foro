package com.ForoHub.Foro.Api.Domain.Topico.Topico.Validations;

import com.ForoHub.Foro.Api.Domain.Curso.CurseRepository;
import com.ForoHub.Foro.Api.Domain.Topico.Topico.TopicoData;
import com.ForoHub.Foro.Api.Domain.Topico.Topico.TopicoRepository;
import com.ForoHub.Foro.Api.Domain.Users.UserRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ValidateTopico implements InterfValidateTopico {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CurseRepository curseRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public void validate(TopicoData topicoData) {

        validateTitleTopico ( topicoData );

        validateMessageTopico ( topicoData );

        validateCursoTopico ( topicoData );

        validateRespuestaTopico ( topicoData );

        validateActiveUserTopico ( topicoData );

        validateActiveCurseTopico ( topicoData );

        validateExistTitleTopico ( topicoData );
    }

    public void validateUpdate(TopicoData topicoData) {

        validateUserTopico ( topicoData );

        validateTitleTopico ( topicoData );

        validateMessageTopico ( topicoData );

        validateCursoTopico ( topicoData );

        validateRespuestaTopico ( topicoData );

        validateActiveCurseTopico ( topicoData );

        validateExistTitleTopico ( topicoData );
    }

    public void validateSerchByIdTopico(int idtopico) {

        String existTopico = topicoRepository.getTitleTopicoByIdTopico( idtopico );

        if (Objects.equals ( existTopico , null )) {
            throw new ValidationException ("El topico seleccionado no existe en la base de datos.");
        }

    }

    private void validateUserTopico(TopicoData topicoData) {
        System.out.println ( "validateUserTopico: " + topicoData.iduser () );
        if (!Objects.equals ( topicoData.iduser (), 0)) {
            throw new ValidationException ("No se puede actualizar el usuario que creo el registro.");
        }
    }

    private void validateTitleTopico(TopicoData topicoData) {
        if (topicoData.titulo ( ).isEmpty ( )) {
            throw new ValidationException ("El titulo del topico no puede ser nulo.");
        }
    }

    private void validateMessageTopico(TopicoData topicoData) {

        if (topicoData.mensaje ( ).isEmpty ( )) {
            throw new ValidationException ("El mensaje del topico no puede ser nulo.");
        }
    }

    private void validateCursoTopico(TopicoData topicoData) {

        if (topicoData.idcurso ( ) == 0) {
            throw new ValidationException ("El curso del topico no puede ser nulo.");
        }
    }

    private void validateRespuestaTopico(TopicoData topicoData) {

        if (topicoData.respuesta ( ).isEmpty ( )) {
            throw new ValidationException ("La respuesta no puede estar vacia.");
        }
    }

    private void validateActiveUserTopico(TopicoData topicoData) {

        String ActiveUser = userRepository.getStatusUserId( topicoData.iduser () );

        if (!Objects.equals ( ActiveUser , "1" )) {
            throw new ValidationException ("Este usuario no se encuentra activo en el sistema.");
        }
    }

    private void validateActiveCurseTopico(TopicoData topicoData) {

        String ActiveCurse = curseRepository.getStatusUserId ( topicoData.idcurso ( ) );

        if (!Objects.equals ( ActiveCurse , "1" )) {
            throw new ValidationException ( "Este curso no se encuentra activo en el sistema." );
        }
    }

    private void validateExistTitleTopico(TopicoData topicoData) {

        String ExistTopico = topicoRepository.verifiedExistTitleTopico ( topicoData.titulo () );

        if (!Objects.equals ( ExistTopico , null )) {
            throw new ValidationException ("Ya existe un topico registrado con este titulo.");
        }
    }

}
