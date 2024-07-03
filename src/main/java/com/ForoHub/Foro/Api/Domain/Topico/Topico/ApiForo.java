package com.ForoHub.Foro.Api.Domain.Topico.Topico;

import com.ForoHub.Foro.Api.Domain.Curso.ListCursoData;
import com.ForoHub.Foro.Api.Domain.Estados.ListEstadoData;
import com.ForoHub.Foro.Api.Domain.Topico.Respuestas.ListRespData;
import com.ForoHub.Foro.Api.Domain.Users.ListUserData;

import java.time.LocalDateTime;
import java.util.List;

public record ApiForo(
        int idtopico,
        String titulo,
        String mensaje,
        List<ListUserData> UserData,
        List<ListCursoData> CursoData,
        String Estado,
        LocalDateTime dateregister,
        List<ListRespData> Respuestas
    ) {
}
