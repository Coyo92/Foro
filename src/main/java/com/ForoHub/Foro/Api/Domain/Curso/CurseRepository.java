package com.ForoHub.Foro.Api.Domain.Curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CurseRepository extends JpaRepository<CursoApi, Long> {

    List<ListCursoData> findCursoApiByIdcurso(int id);

    @Query("select ifnull(max(e.idcurso),0) + 1 as idtopico from CursoApi e")
    int getSecuenceCurso();

    @Query("select s.status from CursoApi s where s.idcurso= :idcurso")
    String getStatusUserId(int idcurso);
}
