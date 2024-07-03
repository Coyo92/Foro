package com.ForoHub.Foro.Api.Domain.Topico.Topico;

import com.ForoHub.Foro.Api.Domain.Topico.Respuestas.RespuestaData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicoData(
        //@NotBlank
        int idtopico,
        //@NotBlank
        String titulo,
        //@NotBlank
        String mensaje,
        @NotNull
        @Valid
        int iduser,
        //@NotBlank
        int idcurso,
        //@NotBlank
        String respuesta,
        //@NotBlank
        int status,
        //@NotBlank
        LocalDateTime dateregister
    ) {
}
