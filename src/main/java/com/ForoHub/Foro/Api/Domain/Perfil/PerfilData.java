package com.ForoHub.Foro.Api.Domain.Perfil;

import java.time.LocalDateTime;

public record PerfilData(
        int idperfil,
        String nombre,
        int status,
        LocalDateTime dateregister) {
}
