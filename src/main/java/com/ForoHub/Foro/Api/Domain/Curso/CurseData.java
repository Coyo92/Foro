package com.ForoHub.Foro.Api.Domain.Curso;

import java.time.LocalDateTime;

public record CurseData(
        int idcurso,
        String nombre,
        String categoria,
        int status,
        LocalDateTime dateregister
)  {
}
