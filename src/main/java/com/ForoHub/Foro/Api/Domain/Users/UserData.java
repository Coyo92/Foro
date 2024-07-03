package com.ForoHub.Foro.Api.Domain.Users;

import java.time.LocalDateTime;

public record UserData(
        int iduser,
        String nombre,
        String idemail,
        String password,
        int idperfil,
        int status,
        LocalDateTime dateregister) {
}
