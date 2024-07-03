package com.ForoHub.Foro.Api.Domain.Perfil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface PerfilRepository extends JpaRepository<PerfilApi, Long>{
    UserDetails findByIdperfil(int idPerfil);

    @Query("select s.status from PerfilApi s where s.idperfil= :idperfil")
    String getStatusPerfilId(int idperfil);

    @Query("select ifnull(max(e.idperfil),0) + 1 as iduser from PerfilApi e")
    int getSecuencePerfil();
}
