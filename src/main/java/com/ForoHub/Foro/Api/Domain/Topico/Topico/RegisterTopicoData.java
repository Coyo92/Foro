package com.ForoHub.Foro.Api.Domain.Topico.Topico;

import java.time.LocalDateTime;

public record RegisterTopicoData (
        int idtopico,
        String titulo,
        String mensaje,
        int iduser,
        int idcurso,
        String respuesta,
        int status,
        LocalDateTime dateregister) {
}
