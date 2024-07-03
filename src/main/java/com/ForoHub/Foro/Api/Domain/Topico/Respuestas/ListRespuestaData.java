package com.ForoHub.Foro.Api.Domain.Topico.Respuestas;

import java.time.LocalDateTime;

public record ListRespuestaData(
        int idrespuesta,
        String mensaje,
        int idtopico,
        int iduser,
        String solucion,
        LocalDateTime dateregister) {

    public ListRespuestaData(RespuestaApi respuestaApi) {
        this(
                respuestaApi.getIdrespuesta (),
                respuestaApi.getMensaje (),
                respuestaApi.getIdtopico (),
                respuestaApi.getIduser (),
                respuestaApi.getSolucion (),
                respuestaApi.getDateregister ()
        );
    }
}
