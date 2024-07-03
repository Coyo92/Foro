package com.ForoHub.Foro.Api.Domain.Estados;

public record ListEstadoData(
        int idstado,
        String estado) {

    public ListEstadoData(EstadosApi estadosApi) {
        this(
                estadosApi.getIdstado (),
                estadosApi.getEstado ()
        );
    }
}
