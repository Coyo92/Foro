package com.ForoHub.Foro.Api.Domain.Topico.Topico;

import java.time.LocalDateTime;

public record ListTopicoData(
        int idtopico,
        String titulo,
        String mensaje,
        int iduser,
        int idcurso,
        String respuesta,
        int status,
        LocalDateTime dateregister) {

    public ListTopicoData(TopicoApi topicoApi) {
        this(topicoApi.getIdtopico (),
                topicoApi.getTitulo (),
                topicoApi.getMensaje (),
                topicoApi.getIduser (),
                topicoApi.getIdcurso (),
                topicoApi.getRespuesta (),
                topicoApi.getStatus (),
                topicoApi.getDateregister ()
        );
    }
}
