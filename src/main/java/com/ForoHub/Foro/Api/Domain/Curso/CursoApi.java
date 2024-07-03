package com.ForoHub.Foro.Api.Domain.Curso;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "curso")
@Entity(name = "CursoApi")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idcurso")
public class CursoApi {

    @Id
    private int idcurso;
    private String nombre;
    private String categoria;
    private int status;
    private LocalDateTime dateregister;

    public CursoApi( CurseData curseData, int idt) {

        this.idcurso = idt;//topicoData.idtopico ();
        this.status = 1;
        this.nombre = curseData.nombre ();
        this.categoria = curseData.categoria ();
        this.dateregister = LocalDateTime.now();
    }
}
