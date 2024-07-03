package com.ForoHub.Foro.Api.Domain.Topico.Respuestas;

import com.ForoHub.Foro.Api.Domain.Users.ListUserData;

import java.time.LocalDateTime;
import java.util.List;

public record ListRespData(
       int idrespuesta,
       String mensaje,
       int idtopico,
       List<ListUserData> UserData,
       String solucion,
       LocalDateTime dateregister) {
}
