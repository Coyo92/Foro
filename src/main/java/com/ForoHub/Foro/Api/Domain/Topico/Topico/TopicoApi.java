package com.ForoHub.Foro.Api.Domain.Topico.Topico;

import com.ForoHub.Foro.Api.Domain.Topico.Respuestas.RegisterRespuestaData;
import com.ForoHub.Foro.Api.Domain.Topico.Respuestas.RespuestaApi;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topico")
@Entity(name = "TopicoApi")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idtopico")
public class TopicoApi {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtopico;
    private String titulo;
    private String mensaje;
    private int iduser;
    private int idcurso;
    private String respuesta;
    private int status;
    private LocalDateTime dateregister;

    public TopicoApi(TopicoData topicoData, int idt) {

        this.idtopico = idt;
        this.status = 1;
        this.titulo = topicoData.titulo ();
        this.mensaje = topicoData.mensaje ();
        this.iduser = topicoData.iduser ();
        this.idcurso = topicoData.idcurso ();
        this.respuesta = topicoData.respuesta ();
        this.dateregister = LocalDateTime.now();
    }

    public TopicoApi(ListTopicoData topicoData) {

        this.idtopico = topicoData.idtopico ();
        this.status = topicoData.status ();
        this.titulo = topicoData.titulo ();
        this.mensaje = topicoData.mensaje ();
        this.iduser = topicoData.iduser ();
        this.idcurso = topicoData.idcurso ();
        this.respuesta = topicoData.respuesta ();
        this.dateregister = topicoData.dateregister ();
    }

    public void udpateTopicoApi(TopicoData topicoData) {
        if (topicoData.titulo () != null) {
            this.titulo = topicoData.titulo ();
        }
        if (topicoData.mensaje () != null) {
            this.mensaje = topicoData.mensaje ();
        }
        if (topicoData.idcurso () != 0) {
            this.idcurso = topicoData.idcurso ();
        }
        if (topicoData.respuesta () !=null) {
            this.respuesta = topicoData.respuesta ();
        }
    }

    public void closeTopic(){
        this.status = 2;
    }
}
