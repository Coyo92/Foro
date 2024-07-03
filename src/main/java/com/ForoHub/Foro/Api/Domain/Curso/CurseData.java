package com.ForoHub.Foro.Api.Domain.Curso;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CurseData(
        int idcurso,
        String nombre,
        String categoria,
        int status,
        LocalDateTime dateregister
)  {
}
