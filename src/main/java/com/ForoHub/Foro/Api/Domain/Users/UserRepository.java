package com.ForoHub.Foro.Api.Domain.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserRepository extends JpaRepository<UserApi, Long> {
    UserDetails findByIdemail(String IdEmail);

    List<ListUserData> findUserApiByIduser(int iduser);

    @Query("select s.status from UserApi s where s.iduser= :iduser")
    String getStatusUserId(int iduser);

    @Query("select s.idemail from UserApi s where s.idemail= :idEmail")
    String getRegisteredEmail(String idEmail);

    @Query("select s.iduser from UserApi s where s.idemail= :idEmail")
    int getEmailByIdUser(String idEmail);

    @Query("select ifnull(max(e.iduser),0) + 1 as iduser from UserApi e")
    int getSecuenceUser();
}
