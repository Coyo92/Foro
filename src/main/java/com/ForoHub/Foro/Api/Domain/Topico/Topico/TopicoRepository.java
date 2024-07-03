package com.ForoHub.Foro.Api.Domain.Topico.Topico;

import com.ForoHub.Foro.Api.Domain.Topico.Respuestas.ListRespuestaData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<TopicoApi, Long> {

    Page<TopicoApi> findTopicoApiBy(Pageable pageable);

    List<ListTopicoData> findTopicoApiBy();

    List<ListTopicoData> findTopicoApiByIdtopico(int idtopico);

    @Query("select ifnull(max(e.idtopico),0) + 1 as idtopico from TopicoApi e")
    int getSecuenceTopico();

    @Query("select s.titulo from TopicoApi s where s.idtopico= :idtopico")
    String getTitleTopicoByIdTopico(int idtopico);

    @Query("select s.titulo from TopicoApi s where s.titulo= :titulo")
    String verifiedExistTitleTopico(String titulo);
}
