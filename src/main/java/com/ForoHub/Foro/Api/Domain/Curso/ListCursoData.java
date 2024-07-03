package com.ForoHub.Foro.Api.Domain.Curso;

public record ListCursoData(
        int idcurso,
        String nombre) {

    public ListCursoData(CursoApi cursoApi) {
        this(
                cursoApi.getIdcurso (),
                cursoApi.getNombre ()
        );
    }
}
