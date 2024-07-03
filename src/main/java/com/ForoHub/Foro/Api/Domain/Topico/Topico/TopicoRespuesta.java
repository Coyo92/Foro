package com.ForoHub.Foro.Api.Domain.Topico.Topico;

import java.time.LocalDateTime;
import java.util.List;

public record TopicoRespuesta(
        int idtopico,
        String titulo,
        String mensaje,
        int iduser,
        int idcurso,
        String respuesta,
        int status,
        LocalDateTime dateregister,
        List<com.ForoHub.Foro.Api.Domain.Topico.Respuestas.ListRespuestaData> respuestaApi
    ) {
}
