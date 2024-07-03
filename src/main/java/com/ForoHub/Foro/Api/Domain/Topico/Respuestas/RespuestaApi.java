package com.ForoHub.Foro.Api.Domain.Topico.Respuestas;


import com.ForoHub.Foro.Api.Domain.Topico.Topico.TopicoApi;
import com.ForoHub.Foro.Api.Domain.Topico.Topico.TopicoData;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuesta")
@Entity(name = "RespuestaApi")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idrespuesta")
public class RespuestaApi {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrespuesta;
    private String mensaje;
    private int idtopico;
    private int iduser;
    private String solucion;
    private LocalDateTime dateregister;

    public RespuestaApi(RespuestaData respuestaData, int idt) {

        this.idrespuesta = idt;
        this.mensaje = respuestaData.mensaje ();
        this.idtopico = respuestaData.idtopico ();
        this.iduser = respuestaData.iduser ();
        this.solucion = respuestaData.solucion ();
        this.dateregister = LocalDateTime.now();
    }

    public RespuestaApi(RespuestaData respuestaData) {

        this.idrespuesta = respuestaData.idrespuesta ();
        this.mensaje = respuestaData.mensaje ();
        this.idtopico = respuestaData.idtopico ();
        this.iduser = respuestaData.iduser ();
        this.solucion = respuestaData.solucion ();
        this.dateregister = respuestaData.dateregister ();
    }
}
