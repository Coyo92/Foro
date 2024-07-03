package com.ForoHub.Foro.Api.Domain.Estados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface EstadoRepository extends JpaRepository<EstadosApi, Long> {

    @Query("select s from EstadosApi s where s.idstado= :idEstado")
    List<ListEstadoData> getListaEstadoById(int idEstado);

    @Query("select s.estado from EstadosApi s where s.idstado= :idEstado")
    String getNombreEstadoById(int idEstado);

    @Query("select ifnull(max(e.idstado),0) + 1 as idestado from EstadosApi e")
    int getSecuenceEstados();
}
