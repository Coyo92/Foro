package com.ForoHub.Foro.Api.Domain.Topico.Respuestas;

import java.time.LocalDateTime;

public record RespuestaData(
        int idrespuesta,
        String mensaje,
        int idtopico,
        int iduser,
        String solucion,
        LocalDateTime dateregister) {
}
