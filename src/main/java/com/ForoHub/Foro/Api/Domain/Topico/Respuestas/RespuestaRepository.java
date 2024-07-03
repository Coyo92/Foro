package com.ForoHub.Foro.Api.Domain.Topico.Respuestas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<RespuestaApi, Long> {

    List<ListRespuestaData> findByIdtopico ( int idTopico );

    @Query("select ifnull(max(e.idrespuesta),0) + 1 as idrespuesta from RespuestaApi e")
    int getSecuenceRespuesta();
}

