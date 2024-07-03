package com.ForoHub.Foro.Api.Domain.Estados;

import java.time.LocalDateTime;

public record EstadoData(
        int idstado,
        String estado,
        LocalDateTime dateregister) {
}
